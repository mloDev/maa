package de.mlo.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

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

import de.mlo.exception.DuplicateReqException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.model.Employee;
import de.mlo.model.Institut;
import de.mlo.model.Req;
import de.mlo.model.Stada;
import de.mlo.model.Student;
import de.mlo.model.examCategory;
import de.mlo.repository.ExamCategoryRepository;
import de.mlo.service.EmployeeService;
import de.mlo.service.InstitutService;
import de.mlo.service.StadaService;
import de.mlo.service.StudentService;

@Controller
@RequestMapping(value = {"/stada"})
public class StadaController {

	/** The business object. */
	static String businessObject = "req"; // used in RedirectAttributes
											// messages

	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	StadaService stadaService;
	
	/** The student service. */
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private InstitutService instService;
	
	@Autowired
	private ExamCategoryRepository examCatRepo;
	
	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	@ModelAttribute("allStudents")
	public List<Student> getAllStudents() {
		return studentService.getStudent();
	}
	
	@ModelAttribute("allEmployee")
	public List<Employee> getAllEmployees() {
		return empService.getEmployees(); 
	}
	
	@ModelAttribute("allInstituts")
	public List<Institut> getAllInstituts() {
		return instService.getInstituts(); 
	}
	
	@ModelAttribute("allExamCategories")
	public List<examCategory> getAllExamCategories() {
		return examCatRepo.findAll(); 
	}
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String getStadaList(Model model) {
		
		List<Stada> stadaList = stadaService.getStadas();
		model.addAttribute("stadaList", stadaList);
		
		// if there was an error in /add, we do not want to overwrite
		// the existing user object containing the errors.
		if (!model.containsAttribute("stadaDTO")) {
			StadaDTO stadaDTO = new StadaDTO();
			model.addAttribute("stadaDTO", stadaDTO);
		}
		return "stada-list";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addStadaPage(@Valid @ModelAttribute StadaDTO stadaDTO,
			BindingResult result, RedirectAttributes redirectAttrs) {
		return "stada-add";

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStada(@Valid @ModelAttribute StadaDTO stadaDTO,
			BindingResult result, RedirectAttributes redirectAttrs) throws Exception {


		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.stadaDTO",
					result);
			redirectAttrs.addFlashAttribute("stadaDTO", stadaDTO);
			return "redirect:/stada/list";
		} else {
			Stada stada = new Stada();
			stada = getStada(stadaDTO);
			stadaService.addStada(stada);
			String message = messageSource
					.getMessage("ctrl.message.success.add", new Object[] {
							businessObject, stada.getTitle() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/stada/list";
		}
	
	}
	
	@RequestMapping(value = "/addStada", method = RequestMethod.GET)
	public String addStadaPageById(
			@RequestParam(value = "id", required = true) Integer id,
			Model model, RedirectAttributes redirectAttrs, @Valid @ModelAttribute StadaDTO stadaDTO,
			BindingResult result) throws StudentNotFoundException, DuplicateReqException {
		model.addAttribute("studentDTO", studentService.getStudent(id));
		stadaDTO.setStudent(studentService.getStudent(id));
		return "stada-add";
	}
	
	@RequestMapping(value = {"/addStada"}, method = RequestMethod.POST)
	public String addStadaById(@RequestParam(value = "id", required = true) Integer id,
			@Valid @ModelAttribute StadaDTO stadaDTO,
			BindingResult result, RedirectAttributes redirectAttrs) throws Exception {


		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.stadaDTO",
					result);
			redirectAttrs.addFlashAttribute("stadaDTO", stadaDTO);
			return "redirect:/student/list";
		} else {
			Stada stada = new Stada();
			stada = getStada(stadaDTO);
			stadaService.addStada(stada);
			String message = messageSource
					.getMessage("ctrl.message.success.add", new Object[] {
							businessObject, stada.getTitle() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/student/edit?id=" + id;
		}
	}
	

	private Stada getStada(StadaDTO stadaDTO) throws StudentNotFoundException {
		Stada stada = new Stada();
		stada.setTitle(stadaDTO.getTitle());
		stada.setId(stadaDTO.getId());
		stada.setMark(stadaDTO.getMark());
		stada.setStudent(studentService.getStudent(stadaDTO.getStudent().getId()));
		return stada;
	}
}
