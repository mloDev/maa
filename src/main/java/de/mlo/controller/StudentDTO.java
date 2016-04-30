package de.mlo.controller;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import de.mlo.enums.Gender;
import de.mlo.model.Req;
import lombok.Getter;
import lombok.Setter;

public class StudentDTO {
	
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
	
	@NotNull(message = "{error.student.matNoOld.null}")
	@NotEmpty(message = "{error.student.matNoOld.empty}")
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
	
	@NotNull(message = "{error.student.birthName.null}")
	@NotEmpty(message = "{error.student.birthName.empty}")
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
	private Set<Req> reqList;

}
