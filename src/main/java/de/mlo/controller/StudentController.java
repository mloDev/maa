package de.mlo.controller;

import java.util.ArrayList;
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

import de.mlo.exception.PermissionNotFoundException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.model.Groupe;
import de.mlo.model.Permission;
import de.mlo.model.Student;
import de.mlo.model.User;
import de.mlo.service.GroupeService;
import de.mlo.service.StudentService;
import de.mlo.service.UserService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/student")
public class StudentController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);
	static String businessObject = "student"; // used in RedirectAttributes
											// messages

	@Autowired
	private StudentService studentService;

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listStudents(Model model) {
		logger.debug("IN: Student/list-GET");

		List<Student> students = studentService.getStudent();
		model.addAttribute("students", students);

		// if there was an error in /add, we do not want to overwrite
		// the existing user object containing the errors.
		if (!model.containsAttribute("userDTO")) {
			logger.debug("Adding StudentDTO object to model");
			StudentDTO studentDTO = new StudentDTO();
			model.addAttribute("studentDTO", studentDTO);
		}
		return "student-list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showStudent(@RequestParam(value = "id", required = true) Integer id,
		Model model, RedirectAttributes redirectAttrs) {
			
		logger.debug("IN: studentedit with id " + "ID to query: " + id);
		
		try {
			if (!model.containsAttribute("studentDTO")) {
				logger.debug("Adding studentDTO object to model");
				Student student = studentService.getStudent(id);
				StudentDTO studentDTO = getStudentDTO(student);
				logger.debug("Student/show-GET:  "
						+ studentDTO.toString());
				model.addAttribute("studentDTO", studentDTO);
			}
			return "student-edit";
		} catch (StudentNotFoundException e) {
			String message = messageSource.getMessage(
					"ctrl.message.error.notfound",
					new Object[] { "user id", id }, Locale.US);
			model.addAttribute("error", message);
			return "redirect:/";
		}	
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editStudent(@Valid @ModelAttribute StudentDTO studentDTO,
			BindingResult result, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) {
		return null;
	}

	private StudentDTO getStudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setMatNo(student.getMatNo());
		studentDTO.setMatNoOld(student.getMatNoOld());
		studentDTO.setEMail(student.getEMail());
		studentDTO.setName(student.getName());
		studentDTO.setSurName(student.getSurName());
		studentDTO.setGender(student.getGender());
		studentDTO.setReqList(student.getReqList());
		studentDTO.setLabel(student.getMatNo() + " " + student.getName() + " " + student.getSurName());
		return studentDTO;
	}
	
	private Student getStudent(StudentDTO studentDTO) {
		Student student = new Student(studentDTO.getMatNo(), studentDTO.getMatNoOld(), studentDTO.getName(), studentDTO.getSurName(), studentDTO.getEMail(), studentDTO.getGender(), studentDTO.getReqList());
		return student;
	}
}
