package de.mlo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mlo.exception.UserNotFoundException;
import de.mlo.model.User;
import de.mlo.service.UserService;


@Controller
@RequestMapping(value = "/account")
public class AccountController {
	static Logger logger = LoggerFactory
			.getLogger(AccountController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="setting",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLL_PERM_USER_EDIT_GET')")
	public String usersetting(final Model model) throws UserNotFoundException {
		logger.debug("IN: Setting-GET");
		String username = ((User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUsername();
		User user = userService.getUser(username);
		logger.debug("User/Seetingt-GET:  " + user.toString());
		model.addAttribute("user", user);

		return "account-setting";

	}

}