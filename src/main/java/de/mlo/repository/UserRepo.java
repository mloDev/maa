package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepo.
 */
public interface UserRepo extends JpaRepository<User, Integer>{
	
	/**
	 * Find by username.
	 *
	 * @param Name the name
	 * @return the user
	 */
	User findByUsername(String Name);

}
