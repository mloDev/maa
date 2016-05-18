package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_Semester")
public class Term {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "SEM_ID")
	
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
	
	@Column(name="SEM_Bez")
	@Getter
	@Setter
	private String semDE;

	@Column(name="SEM_engl")
	@Getter
	@Setter
	private String semEN;

		
}
