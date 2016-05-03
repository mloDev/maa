package de.mlo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import de.mlo.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Employee extends BaseEntity {
	
	@Column
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String surName;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private Gender gender;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int telNo;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int telFax;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int telShort;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int privTel;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int privFax;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int mobilNo;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private boolean allowExam;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String privEMail;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String eMail;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String homepage;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private PLZCity plzCity;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String street;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@Getter
	@Setter
	private Title title;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private Institut institut;	
	
	@OneToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private Employment employment;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private int lvvo;
	
	

}
