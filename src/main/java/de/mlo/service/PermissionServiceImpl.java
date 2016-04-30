package de.mlo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mlo.exception.DuplicatePermissionException;
import de.mlo.exception.PermissionNotFoundException;
import de.mlo.model.Permission;
import de.mlo.repository.PermissionRepo;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	static Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Autowired
	private PermissionRepo permissionRepo;

	@Override
	public void addPermission(Permission permission) throws DuplicatePermissionException {
		permissionRepo.save(permission);
		
	}

	@Override
	public Permission getPermission(int id) throws PermissionNotFoundException {
		logger.info("Permission: " + permissionRepo.getOne(id));
		return permissionRepo.getOne(id);
	}

	@Override
	public Permission getPermission(String permissionname) throws PermissionNotFoundException {
		logger.info("PermissionByName: " + permissionRepo.findByPermissionname(permissionname));
		return permissionRepo.findByPermissionname(permissionname);
	}

	@Override
	public void updatePermission(Permission permission)
			throws PermissionNotFoundException, DuplicatePermissionException {
		permissionRepo.saveAndFlush(permission);
		
	}

	@Override
	public void deletePermission(int id) throws PermissionNotFoundException {
		permissionRepo.delete(id);
		
	}

	@Override
	public List<Permission> getPermissions() {
		logger.info("Permission List Size: " + permissionRepo.findAll());
		return permissionRepo.findAll();
	}
}
