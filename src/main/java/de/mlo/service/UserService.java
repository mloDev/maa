package de.mlo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import de.mlo.exception.*;
import de.mlo.model.User;


// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService extends UserDetailsService {
	
	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @throws DuplicateUserException the duplicate user exception
	 */
	public void addUser(User user) throws DuplicateUserException;

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 * @throws UserNotFoundException the user not found exception
	 */
	public User getUser(int userId) throws UserNotFoundException;

	/**
	 * Gets the user.
	 *
	 * @param username the username
	 * @return the user
	 * @throws UserNotFoundException the user not found exception
	 */
	public User getUser(String username) throws UserNotFoundException;

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @throws UserNotFoundException the user not found exception
	 * @throws DuplicateUserException the duplicate user exception
	 */
	public void updateUser(User user) throws UserNotFoundException,
			DuplicateUserException;

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @throws UserNotFoundException the user not found exception
	 */
	public void deleteUser(int userId) throws UserNotFoundException;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<User> getUsers();

}
