package de.mlo.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import de.mlo.exception.DuplicateGroupeException;
import de.mlo.exception.GroupeNotFoundException;
import de.mlo.model.Groupe;
import de.mlo.service.GroupeService;

// TODO: Auto-generated Javadoc
/**
 * The Class GroupeController.
 */
@Controller
@RequestMapping(value = "/groupe")
public class GroupeController {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(GroupeController.class);
	
	/** The business object. */
	static String businessObject = "groupe"; // used in RedirectAttributes
												
												/** The groupe service. */
												// messages
	@Autowired
	private GroupeService groupeService;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * List of groupes.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_GROUPE_LIST_GET')")
	public String listOfGroupes(Model model) {
		logger.debug("IN: Groupe/list-GET");

		List<Groupe> groupes = groupeService.getGroupes();
		model.addAttribute("groupes", groupes);

		// if there was an error in /add, we do not want to overwrite
		// the existing groupe object containing the errors.
		if (!model.containsAttribute("groupe")) {
			logger.debug("Adding Groupe object to model");
			Groupe groupe = new Groupe();
			model.addAttribute("groupe", groupe);
		}
		return "groupe-list";
	}

	/**
	 * Adds the groupe.
	 *
	 * @param groupe the groupe
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CTRL_GROUPE_ADD_POST')")
	public String addGroupe(@Valid @ModelAttribute Groupe groupe,
			BindingResult result, RedirectAttributes redirectAttrs) {

		logger.debug("IN: Groupe/add-POST");

		if (result.hasErrors()) {
			logger.debug("Groupe-add error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.groupe",
					result);
			redirectAttrs.addFlashAttribute("groupe", groupe);
			return "redirect:/groupe/list";
		} else {
			try {
				groupeService.addGroupe(groupe);
				String message = messageSource.getMessage(
						"ctrl.message.success.add", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
				return "redirect:/groupe/list";
			} catch (DuplicateGroupeException e) {
				String message = messageSource.getMessage(
						"ctrl.message.error.duplicate", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/groupe/list";
			}
		}
	}

	/**
	 * Edits the groupe page.
	 *
	 * @param id the id
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_GROUPE_EDIT_GET')")
	public String editGroupePage(
			@RequestParam(value = "id", required = true) Integer id,
			Model model, RedirectAttributes redirectAttrs) {

		logger.debug("IN: Groupe/edit-GET:  ID to query = " + id);

		try {
			if (!model.containsAttribute("groupe")) {
				logger.debug("Adding Groupe object to model");
				Groupe groupe = groupeService.getGroupe(id);
				logger.debug("Groupe/edit-GET:  " + groupe.toString());
				model.addAttribute("groupe", groupe);
			}
			return "groupe-edit";
		} catch (GroupeNotFoundException e) {
			String message = messageSource.getMessage(
					"ctrl.message.error.notfound", new Object[] { "groupe id",
							id }, Locale.US);
			model.addAttribute("error", message);
			return "redirect:/groupe/list";
		}
	}

	/**
	 * Edits the groupe.
	 *
	 * @param groupe the groupe
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @param action the action
	 * @return the string
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CTRL_GROUPE_EDIT_POST')")
	public String editGroupe(@Valid @ModelAttribute Groupe groupe,
			BindingResult result, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) {

		logger.debug("IN: Groupe/edit-POST: " + action);

		if (action.equals(messageSource.getMessage("button.action.cancel",
				null, Locale.US))) {
			String message = messageSource
					.getMessage("ctrl.message.success.cancel", new Object[] {
							"Edit", businessObject, groupe.getGroupename() },
							Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {
			logger.debug("Groupe-edit error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.groupe",
					result);
			redirectAttrs.addFlashAttribute("groupe", groupe);
			return "redirect:/groupe/edit?id=" + groupe.getId();
		} else if (action.equals(messageSource.getMessage("button.action.save",
				null, Locale.US))) {
			logger.debug("Groupe/edit-POST:  " + groupe.toString());
			try {
				groupeService.updateGroupe(groupe);
				String message = messageSource.getMessage(
						"ctrl.message.success.update", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
			} catch (GroupeNotFoundException snf) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/groupe/list";
			} catch (DuplicateGroupeException dse) {
				String message = messageSource.getMessage(
						"ctrl.message.error.duplicate", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/groupe/list";
			}
		}
		return "redirect:/groupe/list";
	}

	/**
	 * Delete groupe page.
	 *
	 * @param id the id
	 * @param phase the phase
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_GROUPE_DELETE_GET')")
	public String deleteGroupePage(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "phase", required = true) String phase,
			Model model, RedirectAttributes redirectAttrs) {

		Groupe groupe;
		String message;

		try {
			groupe = groupeService.getGroupe(id);
		} catch (GroupeNotFoundException e) {
			message = messageSource.getMessage("ctrl.message.error.notfound",
					new Object[] { "Groupe number", id }, Locale.US);
			redirectAttrs.addFlashAttribute("error", message);
			return "redirect:/groupe/list";
		}

		logger.debug("IN: Groupe/delete-GET | id = " + id + " | phase = "
				+ phase + " | " + groupe.toString());

		if (phase.equals(messageSource.getMessage("button.action.cancel", null,
				Locale.US))) {
			message = messageSource.getMessage(
					"ctrl.message.success.cancel",
					new Object[] { "Delete", businessObject,
							groupe.getGroupename() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/groupe/list";
		} else if (phase.equals(messageSource.getMessage("button.action.stage",
				null, Locale.US))) {
			model.addAttribute("groupe", groupe);
			return "groupe-delete";
		} else if (phase.equals(messageSource.getMessage(
				"button.action.delete", null, Locale.US))) {
			try {
				groupeService.deleteGroupe(id);
				message = messageSource.getMessage(
						"ctrl.message.success.delete", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
				return "redirect:/groupe/list";
			} catch (GroupeNotFoundException e) {
				message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								businessObject, groupe.getGroupename() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/groupe/list";
			}
		}

		return "redirect:/groupe/list";
	}

}
