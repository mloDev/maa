package de.mlo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.mlo.enums.ExamTry;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Stada.
 */
@Entity
@Table(name="tbl_StADAs")
public class Stada {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "STADA_ID")
	
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

	/** The student. */
	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "STADA_STUD_ID")
	private Student student;
	
	/** The institut. */
	@OneToOne
	@Getter
	@Setter
	@JoinColumn(name="STADA_ABT_ID")
	private Institut institut;
	
	/** The exam category. */
	@OneToOne
	@Getter
	@Setter
	@JoinColumn(name="STADA_PB_ID")
	private examCategory examCategory;
	
	/** The mark. */
	@Column(name="STADA_Note")
	
	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	@Getter
	
	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	@Setter
	private int mark;
	
	/** The employee one. */
	@OneToOne
	@Getter
	@Setter
	@JoinColumn(name="STADA_IvIMit1_ID")
	private Employee employeeOne;
	
	/** The employee two. */
	@OneToOne
	@Getter
	@Setter
	@JoinColumn(name="STADA_IvIMit2_ID")
	private Employee employeeTwo;
	
	/** The start. */
	@Column(name="STADA_Beginn")
	
	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	@Getter
	
	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	@Setter
	private Date start;
	
	/** The end. */
	@Column(name="STADA_Ende")
	
	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	@Getter
	
	/**
	 * Sets the end.
	 *
	 * @param end the new end
	 */
	@Setter
	private Date end;
	
	/** The due. */
	@Column(name="STADA_Abgabe")
	
	/**
	 * Gets the due.
	 *
	 * @return the due
	 */
	@Getter
	
	/**
	 * Sets the due.
	 *
	 * @param due the new due
	 */
	@Setter
	private Date due;
	
	/** The pause. */
	@Column(name="STADA_Pause")
	
	/**
	 * Gets the pause.
	 *
	 * @return the pause
	 */
	@Getter
	
	/**
	 * Sets the pause.
	 *
	 * @param pause the new pause
	 */
	@Setter
	private Date pause;
	
	/** The ban. */
	@Column(name="STADA_Sperre")
	
	/**
	 * Gets the ban.
	 *
	 * @return the ban
	 */
	@Getter
	
	/**
	 * Sets the ban.
	 *
	 * @param ban the new ban
	 */
	@Setter
	private Date ban;
	
	/** The stada no. */
	@Column(name="STADA_NrSTADA")
	
	/**
	 * Gets the stada no.
	 *
	 * @return the stada no
	 */
	@Getter
	
	/**
	 * Sets the stada no.
	 *
	 * @param stadaNo the new stada no
	 */
	@Setter
	private int stadaNo;
	
	/** The title. */
	@Column(name="STADA_Titel")
	
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
	private String title;
	
	/** The note. */
	@Column(name="STADA_Notiz")
	
	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	@Getter
	
	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	@Setter
	private String note;
	
	/** The is public. */
	@Column(name="STADA_public")
	
	/**
	 * Checks if is public.
	 *
	 * @return true, if is public
	 */
	@Getter
	
	/**
	 * Sets the public.
	 *
	 * @param isPublic the new public
	 */
	@Setter
	private boolean isPublic;
	
	/** The is released. */
	@Column(name="STADA_Freigabe")
	
	/**
	 * Checks if is released.
	 *
	 * @return true, if is released
	 */
	@Getter
	
	/**
	 * Sets the released.
	 *
	 * @param isReleased the new released
	 */
	@Setter
	private boolean isReleased;
	
	/** The tries. */
	@Column(name="STADA_Versuch")
	@Enumerated(EnumType.STRING)
	
	/**
	 * Gets the tries.
	 *
	 * @return the tries
	 */
	@Getter
	
	/**
	 * Sets the tries.
	 *
	 * @param tries the new tries
	 */
	@Setter
	private ExamTry tries;
	
	/** The usl. */
	@Column(name="STADA_USL")
	
	/**
	 * Checks if is usl.
	 *
	 * @return true, if is usl
	 */
	@Getter
	
	/**
	 * Sets the usl.
	 *
	 * @param USL the new usl
	 */
	@Setter
	private boolean USL;
	
	
	@Column(name="STADA_Abbruch")

	@Getter

	@Setter
	private boolean abbruch;
}
