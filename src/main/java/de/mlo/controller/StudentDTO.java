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

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDTO.
 */
public class StudentDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7554982482666335859L;

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
	 * Gets the label.
	 *
	 * @return the label
	 */
	@Getter
	
	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	@Setter
	private String label;
	
	/** The mat no. */
	@NotNull(message = "{error.student.matNo.null}")
	@NotEmpty(message = "{error.student.matNo.empty}")
	@Size(max = 50, message = "{error.student.matNo.max}")
	
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
	@Size(max = 50, message = "{error.studentOld.matNo.max}")
	
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
	@NotNull(message = "{error.student.name.null}")
	@NotEmpty(message = "{error.student.name.empty}")
	@Size(max = 50, message = "{error.student.name.max}")
	
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
	@NotNull(message = "{error.student.surName.null}")
	@NotEmpty(message = "{error.student.surName.empty}")
	@Size(max = 50, message = "{error.student.surName.max}")
	
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
	@Size(max = 50, message = "{error.student.birthName.max}")
	
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
	private Date gebDate;
	
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

}
