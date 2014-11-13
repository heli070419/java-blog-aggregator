<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/tablib.jsp"%>

<h1>${user.name}</h1>


<script type="text/javascript">
$(document).ready(function(){
	$('.nav-tabs a:first').tab('show');
	$(".triggerRemove").click(function(e){
		e.preventDefault();
		$('#modalRemove .removeBtn').attr("href",$(this).attr("href"));
		$('#modalRemove').modal();
	});
});
</script>

<!-- Nav tabs -->
<ul class="nav nav-tabs" role="tablist">
	<c:forEach items="${user.blogs}" var="blog">
		<li><a href="#blog_${blog.id}" role="tab" data-toggle="tab">${blog.name}</a></li>
	</c:forEach>
</ul>

<!-- Tab panes -->
<div class="tab-content">
	<c:forEach items="${user.blogs}" var="blog">
		<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
			<p>
			<h1>
			<a class="btn btn-danger triggerRemove" href="<spring:url value="/blog/remove/${blog.id}.html" />">Remove blog</a>
				<c:out value="${blog.name}" />
			</h1>
			<p>
				<c:out value="${blog.url}" />
			</p>
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Link</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${blog.items}" var="item">
						<tr>
							<td>${item.title}</td>
							<td>${item.link}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:forEach>
</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       <a href="" class="btn btn-danger removeBtn">Remove</a> 
      </div>
    </div>
  </div>
</div>