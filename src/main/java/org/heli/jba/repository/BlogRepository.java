package org.heli.jba.repository;

import java.util.List;

import org.heli.jba.entity.Blog;
import org.heli.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer>  {

	List<Blog> findByUser(User user);
}
