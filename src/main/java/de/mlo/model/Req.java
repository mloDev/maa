package de.mlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Req.
 */
@Entity
@Table(name = "tbl_PruefungsAusschuss")
public class Req implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8115733602274019649L;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "id")
	
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
	@Getter
	@ManyToOne
	@JoinTable(name = "student_reqs")
	private Student student;
	
	

}
