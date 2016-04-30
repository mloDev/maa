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

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	static Logger logger = LoggerFactory.getLogger(GroupeServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public void addUser(User user) throws DuplicateUserException {
		userRepo.save(user);
		
	}

	@Override
	public User getUser(int userId) throws UserNotFoundException {
		return userRepo.getOne(userId);
	}

	@Override
	public User getUser(String username) throws UserNotFoundException {
		return userRepo.findByUsername(username);
	}

	@Override
	public void updateUser(User user) throws UserNotFoundException, DuplicateUserException {
		userRepo.saveAndFlush(user);
		
	}

	@Override
	public void deleteUser(int userId) throws UserNotFoundException {
		userRepo.delete(userId);
		
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return getUser(username);
		} catch (UserNotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

}
