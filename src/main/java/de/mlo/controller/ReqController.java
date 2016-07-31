package de.mlo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import de.mlo.exception.DuplicateReqException;
import de.mlo.exception.DuplicateUserException;
import de.mlo.exception.ReqNotFoundException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.exception.UserNotFoundException;
import de.mlo.model.Req;
import de.mlo.model.Restrictions;
import de.mlo.model.Student;
import de.mlo.repository.RestrictionRepository;
import de.mlo.service.ReqService;
import de.mlo.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReqController.
 */
@Controller
@RequestMapping(value = "/req")
public class ReqController {
	
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

	/** The logger. */
	static Logger logger = LoggerFactory
			.getLogger(ReqController.class);
	
	/** The business object. */
	static String businessObject = "req"; // used in RedirectAttributes
											// messages

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The req service. */
	@Autowired 
	private ReqService reqService;
	
	/** The student service. */
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RestrictionRepository restrictionRepo;
	
	
	@ModelAttribute("allSRestrictions")
	public List<Restrictions> getAllRestrictions() {
		return restrictionRepo.findAll();
	}
	
	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	@ModelAttribute("allStudents")
	public List<Student> getAllStudents() {
		return studentService.getStudent();
	}
	
	/**
	 * List users.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(Model model) {

		List<Req> reqs = reqService.getReqs();
		model.addAttribute("reqs", reqs); 

		// if there was an error in /add, we do not want to overwrite
		// the existing user object containing the errors.
		if (!model.containsAttribute("reqDTO")) {
			ReqDTO reqDTO = new ReqDTO();
			model.addAttribute("reqDTO", reqDTO);
		}
		return "req-list";
	}
	
	
	/**
	 * Addreqpage.
	 *
	 * @param reqDTO the req dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addreqpage(@Valid @ModelAttribute ReqDTO reqDTO,
			BindingResult result, RedirectAttributes redirectAttrs) {
		return "req-add";

	}
	
	/**
	 * Adds the user.
	 *
	 * @param reqDTO the req dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addReq(@Valid @ModelAttribute ReqDTO reqDTO,
			BindingResult result, RedirectAttributes redirectAttrs) throws Exception {


		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.reqDTO",
					result);
			redirectAttrs.addFlashAttribute("reqDTO", reqDTO);
			return "redirect:/req/list";
		} else {
			Req req = new Req();
			req = getReq(reqDTO);
			reqService.addReq(req);
			String message = messageSource
					.getMessage("ctrl.message.success.add", new Object[] {
							businessObject, req.getId()}, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/req/list";
		}
	}

	
	@RequestMapping(value = "/addRequest", method = RequestMethod.GET)
	public String addReqPageById(
			@RequestParam(value = "id", required = true) Integer id,
			Model model, RedirectAttributes redirectAttrs, @Valid @ModelAttribute ReqDTO reqDTO,
			BindingResult result) throws DuplicateReqException, ReqNotFoundException, StudentNotFoundException {
		model.addAttribute("studentDTO", studentService.getStudent(id));
		reqDTO.setStudent(studentService.getStudent(id));
		return "req-add";
	}
	
	@RequestMapping(value = {"/addRequest"}, method = RequestMethod.POST)
	public String addReqById(@RequestParam(value = "id", required = true) Integer id,
			@Valid @ModelAttribute ReqDTO reqDTO,
			BindingResult result, RedirectAttributes redirectAttrs) throws Exception {


		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.reqDTO",
					result);
			redirectAttrs.addFlashAttribute("reqDTO", reqDTO);
			logger.info("ReqDTO add error: " + result.toString());
			return "redirect:/student/edit?id=" + id;
		} else {
			Req req = new Req();
			req = getReq(reqDTO);
			reqService.addReq(req);
			String message = messageSource
					.getMessage("ctrl.message.success.add", new Object[] {
							businessObject, req.getId() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/student/edit?id=" + id;
		}
	}
	
	/**
	 * Gets the req.
	 *
	 * @param reqDTO the req dto
	 * @return the req
	 * @throws StudentNotFoundException the student not found exception
	 */
	private Req getReq(ReqDTO reqDTO) throws StudentNotFoundException {
		Req req = new Req();
		req.setAnlege(reqDTO.getAnlege());
		req.setBetr(reqDTO.getBetr());
		req.setDiv(reqDTO.getDiv());
		req.setExamTry(reqDTO.getExamTry());
		req.setMark(reqDTO.getMark());
		req.setNote(reqDTO.getNote());
		req.setResone(reqDTO.getResone());
		req.setRestriction(reqDTO.getRestriction());
		req.setSchein(reqDTO.isSchein());
		req.setFrist(reqDTO.isFrist());
		req.setStudent(studentService.getStudent(reqDTO.getStudent().getId()));
		return req;
	}


	/**
	 * Edits the req page.
	 *
	 * @param id the id
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 * @throws ReqNotFoundException the req not found exception
	 * @throws UserNotFoundException the user not found exception
	 * @throws StudentNotFoundException 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editReqPage(
			@RequestParam(value = "id", required = true) Integer id,
			Model model, RedirectAttributes redirectAttrs) throws ReqNotFoundException, UserNotFoundException, StudentNotFoundException {


		if (!model.containsAttribute("reqDTO")) {
			Req req = reqService.getReq(id);
			ReqDTO reqDTO = getReqDTO(req);
			model.addAttribute("reqDTO", reqDTO);
		}
		return "req-edit";
	}

	/**
	 * Gets the req dto.
	 *
	 * @param req the req
	 * @return the req dto
	 * @throws StudentNotFoundException 
	 */
	private ReqDTO getReqDTO(Req req) throws StudentNotFoundException {
		ReqDTO reqDTO = new ReqDTO();
		reqDTO.setId(req.getId());
		reqDTO.setAnlege(req.getAnlege());
		reqDTO.setBetr(req.getBetr());
		reqDTO.setDiv(req.getDiv());
		reqDTO.setExamTry(req.getExamTry());
		reqDTO.setMark(req.getMark());
		reqDTO.setNote(req.getNote());
		reqDTO.setResone(req.getResone());
		reqDTO.setRestriction(req.getRestriction());
		reqDTO.setSchein(req.isSchein());
		reqDTO.setFrist(req.isFrist());
		reqDTO.setStudent(studentService.getStudent(req.getStudent().getId()));
		return reqDTO;
	}


	/**
	 * Edits the user.
	 *
	 * @param reqDTO the req dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @param action the action
	 * @return the string
	 * @throws ReqNotFoundException the req not found exception
	 * @throws DuplicateReqException the duplicate req exception
	 * @throws DuplicateUserException the duplicate user exception
	 * @throws UserNotFoundException the user not found exception
	 * @throws StudentNotFoundException the student not found exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser(@Valid @ModelAttribute ReqDTO reqDTO,
			BindingResult result, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) throws ReqNotFoundException, DuplicateReqException, DuplicateUserException, UserNotFoundException, StudentNotFoundException {


		if (action.equals(messageSource.getMessage("button.action.cancel",
				null, Locale.US))) {
			String message = messageSource.getMessage(
					"ctrl.message.success.cancel", new Object[] { "Edit",
							businessObject, reqDTO.getId() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.reqDTO",
					result);
			redirectAttrs.addFlashAttribute("reqDTO", reqDTO);
			return "redirect:/req/edit?id=" + reqDTO.getId();
		} else if (action.equals(messageSource.getMessage("button.action.save",
				null, Locale.US))) {
			Req req = getReq(reqDTO);
			reqService.updateReq(req);;
			String message = messageSource.getMessage(
					"ctrl.message.success.update", new Object[] {
							businessObject, reqDTO.getId() },
					Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		}
		return "redirect:/req/list";
	}
}
