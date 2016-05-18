package de.mlo.controller;

import de.mlo.enums.Gender;
import de.mlo.model.Employment;
import de.mlo.model.Institut;
import de.mlo.model.PLZCity;
import de.mlo.model.Title;
import lombok.Getter;
import lombok.Setter;

public class EmployeeDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1450008427418240366L;
	
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String label;
	
	@Getter
	@Setter
	private String surName;

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private Gender gender;
	
	@Getter
	@Setter
	private String telNo;
	
	@Getter
	@Setter
	private String telFax;
	
	@Getter
	@Setter
	private String privTel;
	
	@Getter
	@Setter
	private String privFax;
	
	@Getter
	@Setter
	private String telShort;
	
	@Getter
	@Setter
	private String mobilNo;
	
	@Getter
	@Setter
	private boolean allowExam;
	
	@Getter
	@Setter
	private String eMail;
	
	@Getter
	@Setter
	private String privEMail;
	
	@Getter
	@Setter
	private String homepage;

	@Getter
	@Setter
	private PLZCity plzCity;
	
	@Getter
	@Setter
	private String Street;
	
	@Getter
	@Setter
	private Title title;
	
	@Getter
	@Setter
	private Institut institut;
	
	@Getter
	@Setter
	private Employment employment;
	
	@Getter
	@Setter
	private int lvvo;
	
	@Getter
	@Setter
	private boolean archived;
}
