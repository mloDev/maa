package de.mlo.controller;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDTO.
 */
public class UserDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6370403862305174713L;

	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(UserDTO.class);

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@Setter
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Getter
	private int id;

	/** The username. */
	@NotNull(message = "{error.user.username.null}")
	@NotEmpty(message = "{error.user.username.empty}")
	@Size(max = 50, message = "{error.user.username.max}")
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	@Setter
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Getter
	private String username;

	/** The password. */
	@NotNull(message = "{error.user.password.null}")
	@NotEmpty(message = "{error.user.password.empty}")
	@Size(max = 50, message = "{error.user.password.max}")
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@Setter
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Getter
	private String password;
	
	/** The phone. */
	@NotNull(message = "{error.user.phone.null}")
	@NotEmpty(message = "{error.user.phone.empty}")
	@Size(max = 50, message = "{error.user.phone.max}")
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	@Setter
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@Getter
	private String phone ;
	
	/** The email. */
	@NotNull(message = "{error.user.email.null}")
	@NotEmpty(message = "{error.user.email.empty}")
	@Size(max = 50, message = "{error.user.email.max}")
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	@Setter
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@Getter
	private String email ;
	
	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	@Setter
	
	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Getter
	private boolean enabled;
	
	/**
	 * Sets the groupe id.
	 *
	 * @param groupeId the new groupe id
	 */
	@Setter
	
	/**
	 * Gets the groupe id.
	 *
	 * @return the groupe id
	 */
	@Getter
	private int groupeId;
	
}
