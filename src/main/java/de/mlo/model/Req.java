package de.mlo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.mlo.enums.Resone;
import de.mlo.enums.ExamTry;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Req.
 */
@Entity
@Table(name = "tbl_PruefungsAusschuss")
public class Req {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "PA_ID")
	
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
	 * Sets the student.
	 *
	 * @param student the new student
	 */
	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "PA_STUD_ID")
	private Student student;
	
	@Setter
	@Getter
	@OneToOne
	@JoinColumn(name = "PA_AK_ID")
	private requestCategory cat;

	@Setter
	@Getter
	@OneToOne
	@JoinColumn(name = "PA_AFL_ID")
	private Restrictions restriction;
	
	@Setter
	@Getter
	@Column(name = "PA_Grund")
	@Enumerated(EnumType.STRING)
	private Resone resone;
	
	@Setter
	@Getter
	@Column(name = "PA_RuecktrittFrist")
	private boolean frist;
	
	@Setter
	@Getter
	@Column(name = "PA_Notiz")
	private String note;
	
	@Setter
	@Getter
	@Column(name = "PA_anlegeDat")
	private Date anlege;
	
	@Setter
	@Getter
	@Column(name = "PA_betrDat")
	private Date betr;
	
	@Setter
	@Getter
	@Column(name = "PA_divDat")
	private Date div;
	
	@Setter
	@Getter
	@Column(name = "PA_Note")
	private String mark;
	
	@Setter
	@Getter
	@Column(name = "PA_Schein")
	private boolean schein;
	
	@Setter
	@Getter
	@Column(name = "PA_VersuchPrfg")
	@Enumerated(EnumType.STRING)
	private ExamTry examTry;
}
