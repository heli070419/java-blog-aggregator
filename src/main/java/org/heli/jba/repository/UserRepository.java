package org.heli.jba.repository;

import org.heli.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
