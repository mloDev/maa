package de.mlo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import de.mlo.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
public class Student extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2504308260829915442L;


	public Student() {
		super();
	}
	
	public Student(String matNo, String matNoOld, String name, String surName, String eMail, Gender gender, List<Req> reqList) {
		super();
		this.matNo = matNo;
		this.matNoOld = matNoOld;
		this.surName = surName;
		this.name = name;
		this.reqList = reqList;
		this.eMail = eMail;
		this.gender = gender;
	}
	
	@Column
	@Getter
	@Setter
	private String matNo;
	
	@Column
	@Getter
	@Setter
	private String matNoOld;
	
	@Column
	@Getter
	@Setter
	private String name;
	
	@Column
	@Getter
	@Setter
	private String surName;
	
	@Column
	@Getter
	@Setter
	private String birthName;
	
	@Column
	@Getter
	@Setter
	private String eMail;
	
	@Enumerated(EnumType.STRING)
	@Column
	@Getter
	@Setter
	private Gender gender;
	
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@Getter
	@Setter
	private List<Req> reqList;
	
}
