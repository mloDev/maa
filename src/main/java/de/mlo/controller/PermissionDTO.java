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

public class PermissionDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5074125837362261094L;

	static Logger logger = LoggerFactory.getLogger(PermissionDTO.class);

	@Getter
	@Setter
	private int id;

	@NotNull(message = "{error.permission.permissionname.null}")
	@NotEmpty(message = "{error.permission.permissionname.empty}")
	@Size(max = 50, message = "{permission.permissionname.groupe.max}")
	@Getter
	@Setter
	private String permissionname;

	@Getter
	@Setter
	private List<Integer> permGroupes;

}
