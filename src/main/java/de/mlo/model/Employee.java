package de.mlo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.mlo.enums.Gender;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
@Table(name="tbl_IvIMit")
public class Employee {
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "IvIMit_ID")
	
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
	
	/** The name. */
	@Column(name = "IvIMit_Name")
	
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
	@Column(name = "IvIMit_Vorname", nullable = true)
	
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
	
	/** The gender. */
	@Column(name="IvIMit_Geschlecht", nullable = true)
	
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
	
	/** The tel no. */
	@Column(name = "IvIMit_Telefon", nullable = true)
	
	/**
	 * Gets the tel no.
	 *
	 * @return the tel no
	 */
	@Getter
	
	/**
	 * Sets the tel no.
	 *
	 * @param telNo the new tel no
	 */
	@Setter
	private String telNo;
	
	/** The tel fax. */
	@Column(name = "IvIMit_Fax", nullable = true)
	
	/**
	 * Gets the tel fax.
	 *
	 * @return the tel fax
	 */
	@Getter
	
	/**
	 * Sets the tel fax.
	 *
	 * @param telFax the new tel fax
	 */
	@Setter
	private int telFax;
	
	/** The tel short. */
	@Column(name = "IvIMit_Durchwahl", nullable = true)
	
	/**
	 * Gets the tel short.
	 *
	 * @return the tel short
	 */
	@Getter
	
	/**
	 * Sets the tel short.
	 *
	 * @param telShort the new tel short
	 */
	@Setter
	private int telShort;
	
	/** The priv tel. */
	@Column(name = "IvIMit_PrivTel", nullable = true)
	
	/**
	 * Gets the priv tel.
	 *
	 * @return the priv tel
	 */
	@Getter
	
	/**
	 * Sets the priv tel.
	 *
	 * @param privTel the new priv tel
	 */
	@Setter
	private String privTel;
	
	/** The priv fax. */
	@Column(name = "IvIMit_privFax", nullable = true)
	
	/**
	 * Gets the priv fax.
	 *
	 * @return the priv fax
	 */
	@Getter
	
	/**
	 * Sets the priv fax.
	 *
	 * @param privFax the new priv fax
	 */
	@Setter
	private String privFax;
	
	/** The mobil no. */
	@Column(name = "IvIMit_Mobil", nullable = true)
	
	/**
	 * Gets the mobil no.
	 *
	 * @return the mobil no
	 */
	@Getter
	
	/**
	 * Sets the mobil no.
	 *
	 * @param mobilNo the new mobil no
	 */
	@Setter
	private String mobilNo;
	
	/** The allow exam. */
	@Column(name = "IvIMit_exam", nullable = true)
	
	/**
	 * Checks if is allow exam.
	 *
	 * @return true, if is allow exam
	 */
	@Getter
	
	/**
	 * Sets the allow exam.
	 *
	 * @param allowExam the new allow exam
	 */
	@Setter
	private boolean allowExam;
	
	/** The priv e mail. */
	@Column(name = "IvIMit_PrivMail", nullable = true)
	
	/**
	 * Gets the priv e mail.
	 *
	 * @return the priv e mail
	 */
	@Getter
	
	/**
	 * Sets the priv e mail.
	 *
	 * @param privEMail the new priv e mail
	 */
	@Setter
	private String privEMail;
	
	/** The e mail. */
	@Column(name = "IvIMit_IvIMail", nullable = true)
	
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
	
	/** The homepage. */
	@Column(name = "IvIMit_Homepage", nullable = true)
	
	/**
	 * Gets the homepage.
	 *
	 * @return the homepage
	 */
	@Getter
	
	/**
	 * Sets the homepage.
	 *
	 * @param homepage the new homepage
	 */
	@Setter
	private String homepage;
	
	/** The plz city. */
	@OneToOne(fetch = FetchType.LAZY)
	
	/**
	 * Gets the plz city.
	 *
	 * @return the plz city
	 */
	@Getter
	
	/**
	 * Sets the plz city.
	 *
	 * @param plzCity the new plz city
	 */
	@Setter
	@JoinTable(name = "IvIMit_PLZ_ID")
	private PLZCity plzCity;
	
	/** The street. */
	@Column(name = "IvIMit_Adresse", nullable = true)
	
	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	@Getter
	
	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	@Setter
	private String street;
	
	/** The title. */
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Getter
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	@Setter
	private Title title;
	
	/** The institut. */
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	
	/**
	 * Gets the institut.
	 *
	 * @return the institut
	 */
	@Getter
	
	/**
	 * Sets the institut.
	 *
	 * @param institut the new institut
	 */
	@Setter
	@JoinTable(name="IvIMit_Institut_ID")
	private Institut institut;
	
	@Getter
	@Setter
	@Column(name="IvIMit_Notiz")
	private String notiz;
	
	@Getter
	@Setter
	@Column(name="IvIMit_Buero")
	private String buero;

	@Getter
	@Setter
	@Column(name="IvIMit_PAV")
	private boolean pav;
	
	
	/** The employment. */
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	
	/**
	 * Gets the employment.
	 *
	 * @return the employment
	 */
	@Getter
	
	/**
	 * Sets the employment.
	 *
	 * @param employment the new employment
	 */
	@Setter

	@JoinTable(name="IvIMit_AG_ID")
	private Employment employment;
	
	/** The lvvo. */
	@Column(name="LVVO_ID", nullable = true)
	
	/**
	 * Gets the lvvo.
	 *
	 * @return the lvvo
	 */
	@Getter
	
	/**
	 * Sets the lvvo.
	 *
	 * @param lvvo the new lvvo
	 */
	@Setter
	private int lvvo;
	
	@Column
	@Getter
	@Setter
	private boolean archived;

}
