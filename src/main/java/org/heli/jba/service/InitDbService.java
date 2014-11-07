package org.heli.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.heli.jba.entity.Blog;
import org.heli.jba.entity.Item;
import org.heli.jba.entity.Role;
import org.heli.jba.entity.User;
import org.heli.jba.repository.BlogRepository;
import org.heli.jba.repository.ItemRepository;
import org.heli.jba.repository.RoleRepository;
import org.heli.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogYoutube = new Blog();
		blogYoutube.setName("Youtube");
		blogYoutube.setUrl("https://www.youtube.com");
		blogYoutube.setUser(userAdmin);
		blogRepository.save(blogYoutube);
		
		Item item1 = new Item();
		item1.setBlog(blogYoutube);
		item1.setTitle("first");
		item1.setLink("https://www.youtube.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogYoutube);
		item2.setTitle("second");
		item2.setLink("https://www.youtube.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
	}
}
