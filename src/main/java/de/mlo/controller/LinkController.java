package de.mlo.controller;

import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mlo.model.User;

@Controller
public class LinkController {
	static Logger logger = LoggerFactory.getLogger(LinkController.class);

	@RequestMapping(value = "/")
	public String mainPage(HttpSession session) {
		Collection<GrantedAuthority> authorities = getAuthorities();
		String groupename;
		String gname ="";

		for (GrantedAuthority authority : authorities) {
			
			groupename = authority.getAuthority();

			if (groupename.equals("ADMIN")) {
				gname=groupename ;
				logger.debug("Directing to home page for: [" + groupename + "]");
				session.setAttribute("fragmenttop", "fragments/ADMIN");
				session.setAttribute("fragmentvert", "fragments/ADMIN");
				return "home-admin";
			}
		}
		 if (gname!=("ADMIN")) 
			 {
				logger.debug("Directing to home page for: [" + gname + "]");
				session.setAttribute("fragmenttop", "fragments/USER");
				session.setAttribute("fragmentvert", "fragments/USER");
				return "home-user";
			}


		logger.error("Groupe not found - directing to home page for USER");
		return "home-user";
	}

	@RequestMapping(value = "/index")
	public String indexPage() {
		return "redirect:/";
	}
	


	private Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof User) {
			authorities = ((User) principal).getAuthorities();
		} else {
			logger.error("Principal is not an instance of tn.ansi.web.model.User");
		}
		return authorities;
	}


}
