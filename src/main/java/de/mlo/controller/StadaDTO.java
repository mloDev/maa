package de.mlo.controller;

import java.util.Date;

import de.mlo.model.Employee;
import de.mlo.model.Institut;
import de.mlo.model.Student;
import de.mlo.model.examCategory;
import lombok.Getter;
import lombok.Setter;

public class StadaDTO {
	
	@Getter
	@Setter
	private int id;

	/** The student. */
	@Setter
	@Getter
	private Student student;
	
	/** The institut. */
	@Getter
	@Setter
	private Institut institut;
	
	/** The exam category. */
	@Getter
	@Setter
	private examCategory examCategory;
	
	/** The mark. */
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
	@Getter
	@Setter
	private Employee employeeOne;
	
	/** The employee two. */
	@Getter
	@Setter
	private Employee employeeTwo;
	
	/** The start. */
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
	private boolean madePublic;
	
	/** The is released. */
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
	private boolean released;
	
	/** The tries. */
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
	private int tries;
	
	/** The usl. */
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


}
