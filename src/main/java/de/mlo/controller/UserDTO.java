package de.mlo.controller;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370403862305174713L;

	
	static Logger logger = LoggerFactory.getLogger(UserDTO.class);

	@Setter
	@Getter
	private int id;

	@NotNull(message = "{error.user.username.null}")
	@NotEmpty(message = "{error.user.username.empty}")
	@Size(max = 50, message = "{error.user.username.max}")
	@Setter
	@Getter
	private String username;

	@NotNull(message = "{error.user.password.null}")
	@NotEmpty(message = "{error.user.password.empty}")
	@Size(max = 50, message = "{error.user.password.max}")
	@Setter
	@Getter
	private String password;
	
	@NotNull(message = "{error.user.phone.null}")
	@NotEmpty(message = "{error.user.phone.empty}")
	@Size(max = 50, message = "{error.user.phone.max}")
	@Setter
	@Getter
	private String phone ;
	
	@NotNull(message = "{error.user.email.null}")
	@NotEmpty(message = "{error.user.email.empty}")
	@Size(max = 50, message = "{error.user.email.max}")
	@Setter
	@Getter
	private String email ;
	
	@Setter
	@Getter
	private boolean enabled;
	
	@Setter
	@Getter
	private int groupeId;
	
}
