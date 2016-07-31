package de.mlo.controller;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import de.mlo.enums.ExamTry;
import de.mlo.enums.Resone;
import de.mlo.model.Restrictions;
import de.mlo.model.Student;
import de.mlo.model.requestCategory;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class ReqDTO.
 */
public class ReqDTO {
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Getter
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@Setter
	private int id;
	
	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	@Setter
	
	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	@Getter
	private Student student;
	@Setter
	@Getter
	@OneToOne
	@JoinColumn(name = "PA_AK_ID")
	private requestCategory cat;

	@Setter
	@Getter
	private Restrictions restriction;
	
	@Setter
	@Getter
	private Resone resone;
	
	@Setter
	@Getter
	private boolean frist;
	
	@Setter
	@Getter
	private String note;
	
	@Setter
	@Getter
	private Date anlege;
	
	@Setter
	@Getter
	private Date betr;
	
	@Setter
	@Getter
	private Date div;
	
	@Setter
	@Getter
	private String mark;
	
	@Setter
	@Getter
	private boolean schein;
	
	@Setter
	@Getter
	private ExamTry examTry;


}
