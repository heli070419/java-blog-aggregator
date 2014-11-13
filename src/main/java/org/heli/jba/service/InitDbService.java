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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			User userAdmin = new User();
			userAdmin.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			userAdmin.setEnabled(true);
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleUser);
			roles.add(roleAdmin);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);

			Blog tomcatExpert = new Blog();
			tomcatExpert.setName("Tomcat");
			tomcatExpert.setUrl("http://www.tomcatexpert.com/blog/feed");
			tomcatExpert.setUser(userAdmin);
			blogRepository.save(tomcatExpert);
		}

	}
}
