package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Permission;

public interface PermissionRepo extends JpaRepository<Permission, Integer>{
	
	Permission findByPermissionname(String permissionname);

}
