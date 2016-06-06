package de.mlo.controller;

import java.security.MessageDigest;
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

import de.mlo.exception.DuplicateEmployeeException;
import de.mlo.exception.DuplicateGroupeException;
import de.mlo.exception.EmployeeNotFoundException;
import de.mlo.model.Employee;
import de.mlo.model.Groupe;
import de.mlo.model.Institut;
import de.mlo.model.Title;
import de.mlo.repository.PLZCityRepository;
import de.mlo.repository.TitleRepository;
import de.mlo.service.EmployeeService;
import de.mlo.service.InstitutService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@Controller
@RequestMapping(value = "/employee")
@PreAuthorize("denyAll")
public class EmployeeController {
	
	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	/** The business object. */
	static String businessObject = "employee"; // used in RedirectAttributes
											// messages

	/** The groupe service. */
											@Autowired
	private InstitutService instService;

	/** The employee service. */
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private PLZCityRepository plzRepo;
	
	@Autowired
	private TitleRepository titleRepo;
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Gets the all groupes.
	 *
	 * @return the all groupes
	 */
	@ModelAttribute("allInstituts")
	@PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET','CTRL_USER_EDIT_GET')")
	public List<Institut> getAllGroupes() {
		return instService.getInstituts();
	}
	
	@ModelAttribute("allTitles")
	@PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET','CTRL_USER_EDIT_GET')")
	public List<Title> getAllTitles() {
		return titleRepo.findAll();
	}

	/**
	 * Gets the enabled options.
	 *
	 * @return the enabled options
	 */
	@ModelAttribute("enabledOptions")
	@PreAuthorize("hasAnyRole('CTRL_USER_LIST_GET','CTRL_USER_EDIT_GET')")
	public boolean[] getEnabledOptions() {
		boolean[] array = new boolean[2];
		array[0] = true;
		array[1] = false;
		return array;
	}

	/**
	 * List employees.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_USER_LIST_GET')")
	public String listEmployees(Model model) {
		logger.debug("IN: Employee/list-GET");

		List<Employee> employees = empService.getEmployees();
		model.addAttribute("employees", employees);

		// if there was an error in /add, we do not want to overwrite
		// the existing employee object containing the errors.
		if (!model.containsAttribute("employeeDTO")) {
			logger.debug("Adding EmployeeDTO object to model");
			EmployeeDTO employeeDTO = new EmployeeDTO();
			model.addAttribute("employeeDTO", employeeDTO);
		}
		return "employee-list";
	}

	/**
	 * Addemployeepage.
	 *
	 * @param employeeDTO the employee dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_USER_ADD_GET')")
	public String addemployeepage(@Valid @ModelAttribute EmployeeDTO employeeDTO,
			Model model, BindingResult result, RedirectAttributes redirectAttrs) {

		logger.debug("IN: Employee/add-GET");
		model.addAttribute("allPlzCity", plzRepo.findAll());
		return "employee-add";

	}

	/**
	 * Adds the employee.
	 *
	 * @param employeeDTO the employee dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CTRL_USER_ADD_POST')")
	public String addEmployee(@Valid @ModelAttribute EmployeeDTO employeeDTO,
			BindingResult result, RedirectAttributes redirectAttrs) throws Exception {

		logger.debug("IN: Employee/add-POST");

		if (result.hasErrors()) {
			logger.info("EmployeeDTO add error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.employeeDTO",
					result);
			redirectAttrs.addFlashAttribute("employeeDTO", employeeDTO);
			return "redirect:/employee/list";
		} else {
			Employee employee = new Employee();

			try {
				
				employee = getEmployee(employeeDTO);
				empService.addEmployee(employee);
				String message = messageSource
						.getMessage("ctrl.message.success.add", new Object[] {
								businessObject, employee.getSurName() }, Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
				return "redirect:/employee/list";
			} catch (DuplicateEmployeeException e) {
				String message = messageSource.getMessage(
						"ctrl.message.error.duplicate", new Object[] {
								businessObject, employeeDTO.getSurName() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/employee/list";
			}
		}
	
	}

	/**
	 * Edits the employee page.
	 *
	 * @param id the id
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_USER_EDIT_GET')")
	public String editEmployeePage(
			@RequestParam(value = "id", required = true) Integer id,
			Model model, RedirectAttributes redirectAttrs) {

		logger.debug("IN: Employee/edit-GET:  ID to query = " + id);

		try {
			if (!model.containsAttribute("employeeDTO")) {
				logger.debug("Adding employeeDTO object to model");
				Employee employee = empService.getEmployee(id);
				EmployeeDTO employeeDTO = getEmployeeDTO(employee);
				logger.debug("Employee/edit-GET:  " + employeeDTO.toString());
				model.addAttribute("employeeDTO", employeeDTO);
			}
			return "employee-edit";
		} catch (EmployeeNotFoundException e) {
			String message = messageSource.getMessage(
					"ctrl.message.error.notfound",
					new Object[] { "employee id", id }, Locale.US);
			model.addAttribute("error", message);
			return "redirect:/employee/list";
		}
	}

	/**
	 * Edits the employee.
	 *
	 * @param employeeDTO the employee dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @param action the action
	 * @return the string
	 * @throws DuplicateGroupeException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CTRL_USER_EDIT_POST')")
	public String editEmployee(@Valid @ModelAttribute EmployeeDTO employeeDTO,
			BindingResult result, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) throws DuplicateGroupeException {

		logger.debug("IN: Employee/edit-POST: " + action);

		if (action.equals(messageSource.getMessage("button.action.cancel",
				null, Locale.US))) {
			String message = messageSource.getMessage(
					"ctrl.message.success.cancel", new Object[] { "Edit",
							businessObject, employeeDTO.getSurName() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {
			logger.debug("Employee-edit error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.employeeDTO",
					result);
			redirectAttrs.addFlashAttribute("employeeDTO", employeeDTO);
			return "redirect:/employee/edit?id=" + employeeDTO.getId();
		} else if (action.equals(messageSource.getMessage("button.action.save",
				null, Locale.US))) {
			logger.debug("Employee/edit-POST:  " + employeeDTO.toString());
			try {
				Employee employee = getEmployee(employeeDTO);
				empService.updateEmployee(employee);
				String message = messageSource.getMessage(
						"ctrl.message.success.update", new Object[] {
								businessObject, employeeDTO.getSurName() },
						Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
			} catch (EmployeeNotFoundException unf) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								businessObject, employeeDTO.getSurName() },
						Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/employee/list";
			}
		}
		return "redirect:/employee/list";
	}

	/**
	 * Delete employee.
	 *
	 * @param id the id
	 * @param phase the phase
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@PreAuthorize("hasRole('CTRL_USER_DELETE_GET')")
	public String deleteEmployee(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "phase", required = true) String phase,
			Model model, RedirectAttributes redirectAttrs) {

		Employee employee;
		try {
			employee = empService.getEmployee(id);
		} catch (EmployeeNotFoundException e) {
			String message = messageSource.getMessage(
					"ctrl.message.error.notfound",
					new Object[] { "employee id", id }, Locale.US);
			redirectAttrs.addFlashAttribute("error", message);
			return "redirect:/employee/list";
		}

		logger.debug("IN: Employee/delete-GET | id = " + id + " | phase = " + phase
				+ " | " + employee.toString());

		if (phase.equals(messageSource.getMessage("button.action.cancel", null,
				Locale.US))) {
			String message = messageSource.getMessage(
					"ctrl.message.success.cancel", new Object[] { "Delete",
							businessObject, employee.getSurName() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/employee/list";
		} else if (phase.equals(messageSource.getMessage("button.action.stage",
				null, Locale.US))) {
			logger.debug("     adding employee : " + employee.toString());
			model.addAttribute("employee", employee);
			return "employee-delete";
		} else if (phase.equals(messageSource.getMessage(
				"button.action.delete", null, Locale.US))) {
			try {
				empService.deleteEmployee(employee.getId());
				String message = messageSource
						.getMessage(
								"ctrl.message.success.delete",
								new Object[] { businessObject,
										employee.getSurName() }, Locale.US);
				redirectAttrs.addFlashAttribute("message", message);
				return "redirect:/employee/list";
			} catch (EmployeeNotFoundException e) {
				String message = messageSource.getMessage(
						"ctrl.message.error.notfound", new Object[] {
								"employee id", id }, Locale.US);
				redirectAttrs.addFlashAttribute("error", message);
				return "redirect:/employee/list";
			}
		}

		return "redirect:/employee/list";
	}

	/**
	 * Gets the employee dto.
	 *
	 * @param employee the employee
	 * @return the employee dto
	 */
	@PreAuthorize("hasAnyRole('CTRL_USER_EDIT_GET','CTRL_USER_DELETE_GET')")
	public EmployeeDTO getEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setAllowExam(employee.isAllowExam());
		employeeDTO.setName(employee.getName());
		employeeDTO.setEMail(employee.getEMail());
		employeeDTO.setPrivEMail(employee.getPrivEMail());
		employeeDTO.setLabel(employee.getTitle() + " " + employee.getName() + " " +  employee.getSurName());
		return employeeDTO;
	}

	/**
	 * Gets the employee.
	 *
	 * @param employeeDTO the employee dto
	 * @return the employee
	 */
	@PreAuthorize("hasAnyRole('CTRL_USER_ADD_POST','CTRL_USER_EDIT_POST')")
	public Employee getEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setAllowExam(employeeDTO.isAllowExam());
		employee.setEMail(employeeDTO.getEMail());
		employee.setPrivEMail(employeeDTO.getPrivEMail());
		employee.setName(employeeDTO.getName());
		employee.setSurName(employeeDTO.getSurName());
		employee.setStreet(employeeDTO.getStreet());
		return employee;
	}

	/**
	 * Md5endrypt.
	 *
	 * @param password the password
	 * @return the string
	 * @throws Exception the exception
	 */
	private String md5endrypt(String password) throws Exception{
		
		 
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 		return sb.toString();
		
	}
}