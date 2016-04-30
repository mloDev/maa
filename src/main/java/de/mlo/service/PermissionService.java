package de.mlo.service;

import java.util.List;

import de.mlo.exception.*;
import de.mlo.model.Permission;

public interface PermissionService {
	
	public void addPermission(Permission permission)
			throws DuplicatePermissionException;

	public Permission getPermission(int id) throws PermissionNotFoundException;

	public Permission getPermission(String permissionname)
			throws PermissionNotFoundException;

	public void updatePermission(Permission permission)
			throws PermissionNotFoundException, DuplicatePermissionException;

	public void deletePermission(int id) throws PermissionNotFoundException;

	public List<Permission> getPermissions();

}
