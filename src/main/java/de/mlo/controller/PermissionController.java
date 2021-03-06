package de.mlo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import de.mlo.exception.DuplicatePermissionException;
import de.mlo.exception.GroupeNotFoundException;
import de.mlo.exception.PermissionNotFoundException;
import de.mlo.model.Groupe;
import de.mlo.model.Permission;
import de.mlo.service.GroupeService;
import de.mlo.service.PermissionService;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissionController.
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(PermissionController.class);
	
	/** The business object. */
	static String businessObject = "permission"; // used in RedirectAttributes
													// messages

	/** The groupe service. */
													@Autowired
	private GroupeService groupeService;

	/** The permission service. */
	@Autowired
	private PermissionService permissionService;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Gets the all groupes.
	 *
	 * @return the all groupes
	 */
	@ModelAttribute("allGroupes")
	public List<Groupe> getAllGroupes() {
		return groupeService.getGroupes();
	}

	/**
	 * List permissions.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listPermissions(Model model) {
		logger.debug("IN: Permission/list-GET");

		List<Permission> permissions = permissionService.getPermissions();
		model.addAttribute("permissions", permissions);

		// if there was an error in /add, we do not want to overwrite
		// the existing user object containing the errors.
		if (!model.containsAttribute("permissionDTO")) {
			logger.debug("Adding PermissionDTO object to model");
			PermissionDTO permissionDTO = new PermissionDTO();
			model.addAttribute("permissionDTO", permissionDTO);
		}
		return "permission-list";
	}

	/**
	 * Adds the permission.
	 *
	 * @param permissionDTO the permission dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPermission(
			@Valid @ModelAttribute PermissionDTO permissionDTO,
			BindingResult result, RedirectAttributes redirectAttrs) {

		logger.debug("IN: Permission/add-POST");
		logger.debug("  DTO: " + permissionDTO.toString());

		if (result.hasErrors()) {
			logger.debug("PermissionDTO add error: " + result.toString());
			redirectAttrs
					.addFlashAttribute(
							"org.springframework.validation.BindingResult.permissionDTO",
							result);
			redirectAttrs.addFlashAttribute("permissionDTO", permissionDTO);
			return "redirect:/permission/list";
		} else {
			Permission perm = new Permission();

			try {
				perm = getPermission(permissionDTO);
				permissionService.addPermission(perm);
				String message = messageSource.getMessage(
						"ctrl.message.success.add", new Object[] {
								businessObject, perm.getPermissionname() },
						Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
				return "redirect:/permission/list";
			} catch (DuplicatePermissionException e) {
				String message = messageSource.getMessage(
						"ctrl.message.error.duplicate",
						new Object[] { businessObject,
								permissionDTO.getPermissionname() }, Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/permission/list";
			} catch (GroupeNotFoundException e) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								"groupe ids",
								permissionDTO.getPermGroupes().toString() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/permission/list";
			}
		}
	}

	/**
	 * Edits the permission.
	 *
	 * @param permissionDTO the permission dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @param action the action
	 * @return the string
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPermission(
			@Valid @ModelAttribute PermissionDTO permissionDTO,
			BindingResult result, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) {

		logger.debug("IN: Permission/edit-POST: " + action);

		if (action.equals(messageSource.getMessage("button.action.cancel",
				null, Locale.US))) {
			String message = messageSource.getMessage(
					"ctrl.message.success.cancel",
					new Object[] { "Edit", businessObject,
							permissionDTO.getPermissionname() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {
			logger.debug("Permission-edit error: " + result.toString());
			redirectAttrs
					.addFlashAttribute(
							"org.springframework.validation.BindingResult.permissionDTO",
							result);
			redirectAttrs.addFlashAttribute("permissionDTO", permissionDTO);
			return "redirect:/permission/edit?id=" + permissionDTO.getId();
		} else if (action.equals(messageSource.getMessage("button.action.save",
				null, Locale.US))) {
			logger.debug("Permission/edit-POST:  " + permissionDTO.toString());
			try {
				Permission permission = getPermission(permissionDTO);
				permissionService.updatePermission(permission);
				String message = messageSource.getMessage(
						"ctrl.message.success.update",
						new Object[] { businessObject,
								permissionDTO.getPermissionname() }, Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
			} catch (DuplicatePermissionException unf) {
				String message = messageSource.getMessage(
						"ctrl.message.error.duplicate",
						new Object[] { businessObject,
								permissionDTO.getPermissionname() }, Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/permission/list";
			} catch (PermissionNotFoundException unf) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound",
						new Object[] { businessObject,
								permissionDTO.getPermissionname() }, Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/permission/list";
			} catch (GroupeNotFoundException unf) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								"groupe ids",
								permissionDTO.getPermGroupes().toString() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/permission/list";
			}
		}
		return "redirect:/permission/list";
	}

	/**
	 * Edits the permission page.
	 *
	 * @param id the id
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPermissionPage(
			@RequestParam(value = "id", required = true) Integer id,
			Model model, RedirectAttributes redirectAttrs) {

		logger.debug("IN: Permission/edit-GET:  ID to query = " + id);

		try {
			if (!model.containsAttribute("permissionDTO")) {
				logger.debug("Adding permissionDTO object to model");
				Permission perm = permissionService.getPermission(id);
				PermissionDTO permissionDTO = getPermissionDTO(perm);
				logger.debug("Permission/edit-GET:  "
						+ permissionDTO.toString());
				model.addAttribute("permissionDTO", permissionDTO);
			}
			return "permission-edit";
		} catch (PermissionNotFoundException e) {
			String message = messageSource.getMessage(
					"ctrl.message.error.notfound",
					new Object[] { "user id", id }, Locale.US);
			model.addAttribute("error", message);
			return "redirect:/permission/list";
		}
	}

	/**
	 * Delete permission.
	 *
	 * @param id the id
	 * @param phase the phase
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePermission(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "phase", required = true) String phase,
			Model model, RedirectAttributes redirectAttrs) {

		Permission permission;
		try {
			permission = permissionService.getPermission(id);
		} catch (PermissionNotFoundException e) {
			String message = messageSource.getMessage(
					"ctrl.message.error.notfound", new Object[] {
							"permission id", id }, Locale.US);
			redirectAttrs.addFlashAttribute("error", message);
			return "redirect:/permission/list";
		}

		logger.debug("IN: Permission/delete-GET | id = " + id + " | phase = "
				+ phase + " | " + permission.toString());

		if (phase.equals(messageSource.getMessage("button.action.cancel", null,
				Locale.US))) {
			String message = messageSource.getMessage(
					"ctrl.message.success.cancel", new Object[] { "Delete",
							businessObject, permission.getPermissionname() },
					Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/permission/list";
		} else if (phase.equals(messageSource.getMessage("button.action.stage",
				null, Locale.US))) {
			logger.debug("     deleting permission : " + permission.toString());
			model.addAttribute("permission", permission);
			return "permission-delete";
		} else if (phase.equals(messageSource.getMessage(
				"button.action.delete", null, Locale.US))) {
			try {
				permissionService.deletePermission(permission.getId());
				String message = messageSource.getMessage(
						"ctrl.message.success.delete",
						new Object[] { businessObject,
								permission.getPermissionname() }, Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
				return "redirect:/permission/list";
			} catch (PermissionNotFoundException e) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								"permission id", id }, Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/permission/list";
			}
		}

		return "redirect:/permission/list";
	}

	/**
	 * Gets the permission dto.
	 *
	 * @param perm the perm
	 * @return the permission dto
	 */
	public PermissionDTO getPermissionDTO(Permission perm) {
		List<Integer> groupeIdList = new ArrayList<Integer>();
		PermissionDTO permDTO = new PermissionDTO();
		permDTO.setId(perm.getId());
		permDTO.setPermissionname(perm.getPermissionname());
		for (Groupe groupe : perm.getPermGroupes()) {
			groupeIdList.add(groupe.getId());
		}
		permDTO.setPermGroupes(groupeIdList);
		return permDTO;
	}

	/**
	 * Gets the permission.
	 *
	 * @param permissionDTO the permission dto
	 * @return the permission
	 * @throws GroupeNotFoundException the groupe not found exception
	 */
	public Permission getPermission(PermissionDTO permissionDTO)
			throws GroupeNotFoundException {
		Set<Groupe> groupeList = new HashSet<Groupe>();
		Permission perm = new Permission();
		Groupe groupe = new Groupe();

		perm.setId(permissionDTO.getId());
		perm.setPermissionname(permissionDTO.getPermissionname());
		if (permissionDTO.getPermGroupes() != null) {
			for (Integer groupeId : permissionDTO.getPermGroupes()) {
				groupe = groupeService.getGroupe(groupeId);
				logger.debug("  GROUPE: " + groupe.toString());
				groupeList.add(groupe);
			}
			perm.setPermGroupes(groupeList);
		}
		logger.debug("  PERM: " + perm.toString());
		return perm;
	}

}
