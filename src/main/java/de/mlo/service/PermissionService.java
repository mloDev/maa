package de.mlo.service;

import java.util.List;

import de.mlo.exception.*;
import de.mlo.model.Permission;

// TODO: Auto-generated Javadoc
/**
 * The Interface PermissionService.
 */
public interface PermissionService {
	
	/**
	 * Adds the permission.
	 *
	 * @param permission the permission
	 * @throws DuplicatePermissionException the duplicate permission exception
	 */
	public void addPermission(Permission permission)
			throws DuplicatePermissionException;

	/**
	 * Gets the permission.
	 *
	 * @param id the id
	 * @return the permission
	 * @throws PermissionNotFoundException the permission not found exception
	 */
	public Permission getPermission(int id) throws PermissionNotFoundException;

	/**
	 * Gets the permission.
	 *
	 * @param permissionname the permissionname
	 * @return the permission
	 * @throws PermissionNotFoundException the permission not found exception
	 */
	public Permission getPermission(String permissionname)
			throws PermissionNotFoundException;

	/**
	 * Update permission.
	 *
	 * @param permission the permission
	 * @throws PermissionNotFoundException the permission not found exception
	 * @throws DuplicatePermissionException the duplicate permission exception
	 */
	public void updatePermission(Permission permission)
			throws PermissionNotFoundException, DuplicatePermissionException;

	/**
	 * Delete permission.
	 *
	 * @param id the id
	 * @throws PermissionNotFoundException the permission not found exception
	 */
	public void deletePermission(int id) throws PermissionNotFoundException;

	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	public List<Permission> getPermissions();

}
