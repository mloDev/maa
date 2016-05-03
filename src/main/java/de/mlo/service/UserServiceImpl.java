package de.mlo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mlo.exception.DuplicateUserException;
import de.mlo.exception.UserNotFoundException;
import de.mlo.model.User;
import de.mlo.repository.UserRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(GroupeServiceImpl.class);
	
	/** The user repo. */
	@Autowired
	private UserRepo userRepo;

	/* (non-Javadoc)
	 * @see de.mlo.service.UserService#addUser(de.mlo.model.User)
	 */
	@Override
	public void addUser(User user) throws DuplicateUserException {
		userRepo.save(user);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.UserService#getUser(int)
	 */
	@Override
	public User getUser(int userId) throws UserNotFoundException {
		return userRepo.getOne(userId);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String username) throws UserNotFoundException {
		return userRepo.findByUsername(username);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.UserService#updateUser(de.mlo.model.User)
	 */
	@Override
	public void updateUser(User user) throws UserNotFoundException, DuplicateUserException {
		userRepo.saveAndFlush(user);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.UserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int userId) throws UserNotFoundException {
		userRepo.delete(userId);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.UserService#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return getUser(username);
		} catch (UserNotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

}
