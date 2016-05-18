package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_LehrveranstaltungsProjekte")
public class CourseProject {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "LVP_ID")
	
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
	
	@Column(name="LVP_name")
	@Getter
	@Setter
	private String name;
	

}
