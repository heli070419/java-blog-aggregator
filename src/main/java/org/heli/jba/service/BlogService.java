package org.heli.jba.service;

import java.util.List;

import org.heli.jba.entity.Blog;
import org.heli.jba.entity.Item;
import org.heli.jba.entity.User;
import org.heli.jba.exception.RssException;
import org.heli.jba.repository.BlogRepository;
import org.heli.jba.repository.ItemRepository;
import org.heli.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RssService rssService;
	@Autowired
	private ItemRepository itemRepository;
	
	public void saveItems(Blog blog){
		try {
			List<Item> items = rssService.getItems(blog.getUrl());
			for (Item item : items) {
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if(savedItem == null){
					item.setBlog(blog);
					itemRepository.save(item);
				}
			}
		} catch (RssException e) {
			e.printStackTrace();
		}
		
	}
	// 1 hour = 60 seconds * 60 minutes * 1000
	@Scheduled(fixedDelay=3600000)
	public void reloadBlogs(){
		List<Blog> blogs = blogRepository.findAll();
		for (Blog blog : blogs) {
			saveItems(blog);
		}
	}
	
	public void save(Blog blog, String name){
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		saveItems(blog);
	}

	public void delete(int id) {
		blogRepository.delete(id);
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
		
	}
}
