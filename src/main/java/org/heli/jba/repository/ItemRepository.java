package org.heli.jba.repository;


import java.util.List;

import org.heli.jba.entity.Blog;
import org.heli.jba.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>  {

	List<Item> findByBlog(Blog blog, Pageable pageable);
	
	Item findByBlogAndLink(Blog blog, String link);
}
