package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Permission;

// TODO: Auto-generated Javadoc
/**
 * The Interface PermissionRepo.
 */
public interface PermissionRepo extends JpaRepository<Permission, Integer>{
	
	/**
	 * Find by permissionname.
	 *
	 * @param permissionname the permissionname
	 * @return the permission
	 */
	Permission findByPermissionname(String permissionname);

}
