package org.heli.jba.service;

import java.util.List;

import javax.transaction.Transactional;

import org.heli.jba.entity.Blog;
import org.heli.jba.entity.Item;
import org.heli.jba.entity.User;
import org.heli.jba.repository.BlogRepository;
import org.heli.jba.repository.ItemRepository;
import org.heli.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		System.out.println(userRepository.findAll().size());
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for(Blog blog : blogs){
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
 		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		userRepository.save(user);	
	}
}
