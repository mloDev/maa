package de.mlo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import de.mlo.enums.Gender;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@Entity
@Table(name = "students")
public class Student extends BaseEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2504308260829915442L;


	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}
	
	/**
	 * Instantiates a new student.
	 *
	 * @param matNo the mat no
	 * @param matNoOld the mat no old
	 * @param name the name
	 * @param surName the sur name
	 * @param eMail the e mail
	 * @param gender the gender
	 * @param reqList the req list
	 */
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
	
	/** The mat no. */
	@Column
	
	/**
	 * Gets the mat no.
	 *
	 * @return the mat no
	 */
	@Getter
	
	/**
	 * Sets the mat no.
	 *
	 * @param matNo the new mat no
	 */
	@Setter
	private String matNo;
	
	/** The mat no old. */
	@Column
	
	/**
	 * Gets the mat no old.
	 *
	 * @return the mat no old
	 */
	@Getter
	
	/**
	 * Sets the mat no old.
	 *
	 * @param matNoOld the new mat no old
	 */
	@Setter
	private String matNoOld;
	
	/** The name. */
	@Column
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Getter
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	@Setter
	private String name;
	
	/** The sur name. */
	@Column
	
	/**
	 * Gets the sur name.
	 *
	 * @return the sur name
	 */
	@Getter
	
	/**
	 * Sets the sur name.
	 *
	 * @param surName the new sur name
	 */
	@Setter
	private String surName;
	
	/** The birth name. */
	@Column
	
	/**
	 * Gets the birth name.
	 *
	 * @return the birth name
	 */
	@Getter
	
	/**
	 * Sets the birth name.
	 *
	 * @param birthName the new birth name
	 */
	@Setter
	private String birthName;
	
	/** The e mail. */
	@Column
	
	/**
	 * Gets the e mail.
	 *
	 * @return the e mail
	 */
	@Getter
	
	/**
	 * Sets the e mail.
	 *
	 * @param eMail the new e mail
	 */
	@Setter
	private String eMail;
	
	/** The inactive. */
	@Column
	
	/**
	 * Checks if is inactive.
	 *
	 * @return true, if is inactive
	 */
	@Getter
	
	/**
	 * Sets the inactive.
	 *
	 * @param inactive the new inactive
	 */
	@Setter
	private boolean inactive;
	
	/** The archived. */
	@Column
	
	/**
	 * Checks if is archived.
	 *
	 * @return true, if is archived
	 */
	@Getter
	
	/**
	 * Sets the archived.
	 *
	 * @param archived the new archived
	 */
	@Setter
	private boolean archived;
	
	/** The archiv year. */
	@Column
	
	/**
	 * Gets the archiv year.
	 *
	 * @return the archiv year
	 */
	@Getter
	
	/**
	 * Sets the archiv year.
	 *
	 * @param archivYear the new archiv year
	 */
	@Setter
	private int archivYear;
	
	/** The geb date. */
	@Column
	
	/**
	 * Gets the geb date.
	 *
	 * @return the geb date
	 */
	@Getter
	
	/**
	 * Sets the geb date.
	 *
	 * @param gebDate the new geb date
	 */
	@Setter
	@Type(type="java.util.Date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date gebDate;
	
	/** The phone. */
	@Column
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@Getter
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	@Setter
	private String phone;

	/** The mobile. */
	@Column
	
	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	@Getter
	
	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	@Setter
	private String mobile;
	
	/** The marital status. */
	@Column
	
	/**
	 * Gets the marital status.
	 *
	 * @return the marital status
	 */
	@Getter
	
	/**
	 * Sets the marital status.
	 *
	 * @param maritalStatus the new marital status
	 */
	@Setter
	private String 	maritalStatus;
	
	/** The sv no. */
	@Column
	
	/**
	 * Gets the sv no.
	 *
	 * @return the sv no
	 */
	@Getter
	
	/**
	 * Sets the sv no.
	 *
	 * @param svNo the new sv no
	 */
	@Setter
	private String svNo;
	
	/** The fs. */
	@Column
	
	/**
	 * Gets the fs.
	 *
	 * @return the fs
	 */
	@Getter
	
	/**
	 * Sets the fs.
	 *
	 * @param fs the new fs
	 */
	@Setter
	private int	fs;
	
	/** The price winner. */
	@Column
	
	/**
	 * Checks if is price winner.
	 *
	 * @return true, if is price winner
	 */
	@Getter
	
	/**
	 * Sets the price winner.
	 *
	 * @param priceWinner the new price winner
	 */
	@Setter
	private boolean	priceWinner;
	
	
	
	/** The gender. */
	@Enumerated(EnumType.STRING)
	@Column
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	@Getter
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	@Setter
	private Gender gender;
	
	
	/** The req list. */
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	
	/**
	 * Gets the req list.
	 *
	 * @return the req list
	 */
	@Getter
	
	/**
	 * Sets the req list.
	 *
	 * @param reqList the new req list
	 */
	@Setter
	private List<Req> reqList;
	
}
