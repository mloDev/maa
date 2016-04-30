package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUsername(String Name);

}
