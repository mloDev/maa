package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_Module")
public class Module {
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "MD_ID")
	
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
	
	@Column(name="MD_Name")
	@Getter
	@Setter
	private String name;
	
	@Column(name="MD_Abk")
	@Getter
	@Setter
	private String acronym;
	
	@Column(name="MD_LP")
	@Getter
	@Setter
	private int lp;
	
	@OneToOne
	@Getter
	@Setter
	private Employee employee;
	
	@Column(name="MD_Nummer")
	@Getter
	@Setter
	private int no;

}
