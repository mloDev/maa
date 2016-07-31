package de.mlo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.base.Objects;

import de.mlo.enums.Gender;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@Entity
@Table(name = "tbl_Studenten")
public class Student implements Serializable {
	
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
	 */
	public Student(String matNo, String matNoOld, String name, String surName, String eMail, Gender gender) {
		super();
		this.matNo = matNo;
		this.matNoOld = matNoOld;
		this.surName = surName;
		this.name = name;
		this.eMail = eMail;
		this.gender = gender;
	}
	
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "STUD_ID")
	
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
	
	@Column(name = "STUD_FSUpdDatum")
	@Getter
	@Setter
	private Date FSUpdate;

	@JoinColumn(name = "STUD_STG_ID")
	@Getter
	@Setter
	@OneToOne
	private CoursesOfStudie stg_1;

	@JoinColumn(name = "STUD_STG1_ID")
	@Getter
	@Setter
	@OneToOne
	private CoursesOfStudie stg_2;

	@JoinColumn(name = "STUD_STG2_ID")
	@Getter
	@Setter
	@OneToOne
	private CoursesOfStudie stg_3;

	@JoinColumn(name = "STUD_STAAT_ID")
	@Getter
	@Setter
	@OneToOne
	private State state;
	
	@JoinColumn(name = "STUD_STAAT_ID1")
	@Getter
	@Setter
	@OneToOne
	private State state1;
	
	@JoinColumn(name = "STUD_STAAT_ID2")
	@Getter
	@Setter
	@OneToOne
	private State state2;

	@Column(name = "STUD_KtoNr")
	@Getter
	@Setter
	private String bankNr;

	@JoinColumn(name = "STUD_KK_ID")
	@Getter
	@Setter
	@OneToOne
	private Company KK;
	
	@Column(name = "STUD_privatversichert")
	@Getter
	@Setter
	private boolean privatIns;

	@JoinColumn(name = "STUD_KKOrt_ID")
	@Getter
	@Setter
	@OneToOne
	private PLZCity InsPlace;
	
	@Column(name = "STUD_Adresse")
	@Getter
	@Setter
	private String address;
	
	
	/** The mat no. */
	@Column(name = "STUD_MtrNr")
	
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
	@Column(name = "STUD_MtrNr1")
	
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
	@Column(name = "STUD_Name")
	
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
	@Column(name = "STUD_Vorname")
	
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
	@Column(name = "STUD_GebName")
	
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
	@Column(name = "STUD_Mail")
	
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
	@Column(name = "STUD_blnInaktiv")
	
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
	@Column(name = "STUD_blnArchiv")
	
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
	@Column(name = "STUD_ArchivJahr")
	
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
	@Column(name = "STUD_GebDat")
	
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
	@Column(name = "STUD_Telefon")
	
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
	@Column(name = "STUD_Mobil")
	
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
	@Column(name = "STUD_Familienstand")
	
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
	@Column(name = "STUD_Sv_Nr")
	
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
	@Column(name = "STUD_FS")
	
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
	@Column(name = "STUD_Preistraeger")
	
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
	@Column(name = "STUD_Geschlecht")
	
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
	@OneToMany(mappedBy ="student") 
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
	
	@OneToMany(mappedBy ="student")  
	@Getter
	@Setter
	private List<Stada> stadaList;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof Student) {
			final Student other = (Student) o;
			return Objects.equal(getId(), other.getId())
					&& Objects.equal(getMatNo(),
							other.getMatNo());
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getMatNo());
	}
	
}
