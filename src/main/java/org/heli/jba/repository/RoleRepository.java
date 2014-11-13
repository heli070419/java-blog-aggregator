package org.heli.jba.repository;

import org.heli.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
