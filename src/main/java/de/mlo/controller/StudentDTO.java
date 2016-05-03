package de.mlo.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import de.mlo.enums.Gender;
import de.mlo.model.Req;
import lombok.Getter;
import lombok.Setter;

public class StudentDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554982482666335859L;

	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String label;
	
	@NotNull(message = "{error.student.matNo.null}")
	@NotEmpty(message = "{error.student.matNo.empty}")
	@Size(max = 50, message = "{error.student.matNo.max}")
	@Getter
	@Setter
	private String matNo;
	
	@Size(max = 50, message = "{error.studentOld.matNo.max}")
	@Getter
	@Setter
	private String matNoOld;
	
	@NotNull(message = "{error.student.name.null}")
	@NotEmpty(message = "{error.student.name.empty}")
	@Size(max = 50, message = "{error.student.name.max}")
	@Getter
	@Setter
	private String name;
	
	@NotNull(message = "{error.student.surName.null}")
	@NotEmpty(message = "{error.student.surName.empty}")
	@Size(max = 50, message = "{error.student.surName.max}")
	@Getter
	@Setter
	private String surName;
	
	@Size(max = 50, message = "{error.student.birthName.max}")
	@Getter
	@Setter
	private String birthName;
	
	@Getter
	@Setter
	private String eMail;
	
	@Getter
	@Setter
	private Gender gender;
	
	@Getter
	@Setter
	private List<Req> reqList;
	
	@Getter
	@Setter
	private boolean inactive;
	
	@Getter
	@Setter
	private boolean archived;
	
	@Getter
	@Setter
	private int archivYear;

	@Getter
	@Setter
	private Date gebDate;
	
	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	private String mobile;
	
	@Getter
	@Setter
	private String 	maritalStatus;
	
	@Getter
	@Setter
	private String svNo;
	
	@Getter
	@Setter
	private int	fs;
	
	@Getter
	@Setter
	private boolean	priceWinner;

}
