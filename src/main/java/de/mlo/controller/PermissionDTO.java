package de.mlo.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionDTO.
 */
public class PermissionDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5074125837362261094L;

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(PermissionDTO.class);

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Getter
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@Setter
	private int id;

	/** The permissionname. */
	@NotNull(message = "{error.permission.permissionname.null}")
	@NotEmpty(message = "{error.permission.permissionname.empty}")
	@Size(max = 50, message = "{permission.permissionname.groupe.max}")
	
	/**
	 * Gets the permissionname.
	 *
	 * @return the permissionname
	 */
	@Getter
	
	/**
	 * Sets the permissionname.
	 *
	 * @param permissionname the new permissionname
	 */
	@Setter
	private String permissionname;

	/**
	 * Gets the perm groupes.
	 *
	 * @return the perm groupes
	 */
	@Getter
	
	/**
	 * Sets the perm groupes.
	 *
	 * @param permGroupes the new perm groupes
	 */
	@Setter
	private List<Integer> permGroupes;

}
