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

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionServiceImpl.
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	/** The permission repo. */
	@Autowired
	private PermissionRepo permissionRepo;

	/* (non-Javadoc)
	 * @see de.mlo.service.PermissionService#addPermission(de.mlo.model.Permission)
	 */
	@Override
	public void addPermission(Permission permission) throws DuplicatePermissionException {
		permissionRepo.save(permission);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.PermissionService#getPermission(int)
	 */
	@Override
	public Permission getPermission(int id) throws PermissionNotFoundException {
		logger.info("Permission: " + permissionRepo.getOne(id));
		return permissionRepo.getOne(id);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.PermissionService#getPermission(java.lang.String)
	 */
	@Override
	public Permission getPermission(String permissionname) throws PermissionNotFoundException {
		logger.info("PermissionByName: " + permissionRepo.findByPermissionname(permissionname));
		return permissionRepo.findByPermissionname(permissionname);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.PermissionService#updatePermission(de.mlo.model.Permission)
	 */
	@Override
	public void updatePermission(Permission permission)
			throws PermissionNotFoundException, DuplicatePermissionException {
		permissionRepo.saveAndFlush(permission);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.PermissionService#deletePermission(int)
	 */
	@Override
	public void deletePermission(int id) throws PermissionNotFoundException {
		permissionRepo.delete(id);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.PermissionService#getPermissions()
	 */
	@Override
	public List<Permission> getPermissions() {
		logger.info("Permission List Size: " + permissionRepo.findAll());
		return permissionRepo.findAll();
	}
}
