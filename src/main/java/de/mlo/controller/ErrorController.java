package de.mlo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorController.
 */
@Controller
public class ErrorController {
	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(ErrorController.class);

	/**
	 * Send to403.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/error/accessDeniedPage" }, method = RequestMethod.GET)
	public String sendTo403(Model model) {
		logger.debug("IN: /error/403-GET");
		return "error/403";
	}

	/**
	 * Send to404.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/error/404" }, method = RequestMethod.GET)
	public String sendTo404(Model model) {
		logger.debug("IN: /error/404-GET");
		return "error/404";
	}
	
	/**
	 * Send to405.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/error/405" }, method = RequestMethod.GET)
	public String sendTo405(Model model) {
		logger.debug("IN: /error/405-GET");
		return "error/405";
	}
	
	/**
	 * Send to400.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/error/400" }, method = RequestMethod.GET)
	public String sendTo400(Model model) {
		logger.debug("IN: /error/400-GET");
		return "error/400";
	}

}
