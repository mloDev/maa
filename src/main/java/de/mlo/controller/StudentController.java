package de.mlo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTree;
import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.core.io.*;
import org.springframework.security.access.prepost.PreAuthorize;
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

import de.mlo.exception.DublicateStudentException;
import de.mlo.exception.DuplicateUserException;
import de.mlo.exception.PermissionNotFoundException;
import de.mlo.exception.StudentNotFoundException;
import de.mlo.exception.UserNotFoundException;
import de.mlo.model.Groupe;
import de.mlo.model.Permission;
import de.mlo.model.Student;
import de.mlo.model.User;
import de.mlo.service.GroupeService;
import de.mlo.service.ReqService;
import de.mlo.service.StudentService;
import de.mlo.service.UserService;
import scala.annotation.meta.setter;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentController.
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/student")
public class StudentController {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	/** The business object. */
	static String businessObject = "student"; // used in RedirectAttributes
											// messages

	/** The student service. */
											@Autowired
	private StudentService studentService;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The req service. */
	@Autowired
	private ReqService reqService;
	
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
	
	/**
	 * List students.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listStudents(Model model) {
		logger.debug("IN: Student/list-GET");

		List<Student> students = studentService.getStudent();
		model.addAttribute("students", students);

		// if there was an error in /add, we do not want to overwrite
		// the existing user object containing the errors.
		if (!model.containsAttribute("studentDTO")) {
			logger.debug("Adding StudentDTO object to model");
			StudentDTO studentDTO = new StudentDTO();
			model.addAttribute("studentDTO", studentDTO);
		}
		return "student-list";
	}
	
	/**
	 * Show student.
	 *
	 * @param id the id
	 * @param model the model
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
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
				model.addAttribute("studentReq", studentDTO.getReqList());
				logger.debug("Student " + student.getId() + " with: " + studentDTO.getReqList().size() + " Reqs.");
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
	
	
	/**
	 * Edits the student.
	 *
	 * @param studentDTO the student dto
	 * @param result the result
	 * @param redirectAttrs the redirect attrs
	 * @param action the action
	 * @return the string
	 * @throws UserNotFoundException the user not found exception
	 * @throws DuplicateUserException the duplicate user exception
	 * @throws DublicateStudentException the dublicate student exception
	 * @throws StudentNotFoundException the student not found exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editStudent(@Valid @ModelAttribute StudentDTO studentDTO,
			BindingResult result, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) throws UserNotFoundException, DuplicateUserException, DublicateStudentException, StudentNotFoundException {
		logger.info(result.toString());
		if (action.equals(messageSource.getMessage("button.action.cancel",
				null, Locale.US))) {
			String message = messageSource.getMessage(
					"ctrl.message.success.cancel", new Object[] { "Edit",
							businessObject, studentDTO.getName() }, Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {
			logger.debug("Student-edit error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.studentDTO",
					result);
			redirectAttrs.addFlashAttribute("studentDTO", studentDTO);
			return "redirect:/student/list";
		} else if (action.equals(messageSource.getMessage("button.action.save",
				null, Locale.US))) {
			logger.debug("Student/edit-POST:  " + studentDTO.toString());
			Student student = getStudent(studentDTO);

			logger.info("Student generated id: " + studentDTO.getId());
			studentService.updateStudent(student);

			logger.info("Student saved id: " + student.getId());
			String message = messageSource.getMessage(
					"ctrl.message.success.update", new Object[] {
							businessObject, studentDTO.getName() },
					Locale.US);
			redirectAttrs.addFlashAttribute("message", message);
		}
		return "redirect:/student/edit?id=" + studentDTO.getId();
	}

	/**
	 * Gets the student dto.
	 *
	 * @param student the student
	 * @return the student dto
	 */
	private StudentDTO getStudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setMatNo(student.getMatNo());
		studentDTO.setMatNoOld(student.getMatNoOld());
		studentDTO.setArchived(student.isArchived());
		studentDTO.setBirthName(student.getBirthName());
		studentDTO.setInactive(student.isInactive());
		studentDTO.setPriceWinner(student.isPriceWinner());
		studentDTO.setPhone(student.getPhone());
		studentDTO.setMaritalStatus(student.getMaritalStatus());
		studentDTO.setMobile(student.getMobile());
		studentDTO.setEMail(student.getEMail());
		studentDTO.setGebDate(student.getGebDate());
		studentDTO.setName(student.getName());
		studentDTO.setSurName(student.getSurName());
		studentDTO.setGender(student.getGender());
		studentDTO.setReqList(reqService.getReqsByStudent(student));
		studentDTO.setLabel(student.getMatNo() + " " + student.getName() + " " + student.getSurName());
		studentDTO.setArchivYear(student.getArchivYear());
		studentDTO.setFs(student.getFs());
		studentDTO.setSvNo(student.getSvNo());
		return studentDTO;
	}
	
	/**
	 * Gets the student.
	 *
	 * @param studentDTO the student dto
	 * @return the student
	 */
	private Student getStudent(StudentDTO studentDTO) {
		Student student = new Student(studentDTO.getMatNo(), studentDTO.getMatNoOld(), studentDTO.getName(), studentDTO.getSurName(), studentDTO.getEMail(), studentDTO.getGender(), studentDTO.getReqList());
		student.setId(studentDTO.getId());
		student.setArchived(studentDTO.isArchived());
		student.setBirthName(studentDTO.getBirthName());
		student.setInactive(studentDTO.isInactive());
		student.setPriceWinner(studentDTO.isPriceWinner());
		student.setGebDate(studentDTO.getGebDate());
		student.setPhone(studentDTO.getPhone());
		student.setMobile(studentDTO.getMobile());
		student.setMaritalStatus(studentDTO.getMaritalStatus());
		student.setFs(studentDTO.getFs());
		student.setArchivYear(studentDTO.getArchivYear());
		student.setSvNo(studentDTO.getSvNo());
		return student;
	}
}
