package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_LehrVeranstaltungsArten")
public class CourseCategory {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "LVA_ID")
	
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
	
	@Column(name="LVA_Bez")
	@Getter
	@Setter
	private String name;
	
	@Column(name="LVA_Info")
	@Getter
	@Setter
	private String info;
	
	@Column(name="LVA_LP")
	@Getter
	@Setter
	private int lp;

}
