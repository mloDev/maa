package de.mlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Req.
 */
@Entity
public class Req extends BaseEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8115733602274019649L;



	/** The name. */
	@Column
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	@Setter
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Getter
	private String name;

	/**
	 * Sets the student.
	 *
	 * @param student the new student
	 */
	@Setter
	private Student student;
	
	
	/**
	 * Gets the student.
	 *
	 * @return the student
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student")
	public Student getStudent() {
		return this.student;
		
	}
	

}
