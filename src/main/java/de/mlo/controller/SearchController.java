package de.mlo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.mlo.model.Student;
import de.mlo.service.StudentService;

@Controller
@RequestMapping(value= "/")
public class SearchController {

	
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	static String businessObject = "student"; // used in RedirectAttributes
											// messages
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public @ResponseBody
	List<Student> getStudent(@RequestParam String studentParam) {
		logger.debug("IN:search");
		return simulateSearchResult(studentParam);
	}

	private List<Student> simulateSearchResult(String studentParam) {
		
		List<Student> result = new ArrayList<Student>();
		List<Student> data = studentService.getStudent();
 		// iterate a list and filter by studentParam
		for (Student student : data) {
			if (student.getName().contains(studentParam) || student.getMatNo().contains(studentParam) || student.getSurName().contains(studentParam)) {
				result.add(student);
			}
		}

		return result;
	}

}
