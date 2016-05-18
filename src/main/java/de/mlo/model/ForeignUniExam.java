package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_FremdUniPrfgen")
public class ForeignUniExam {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "FUP_ID")
	
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
	
	@Column(name="RUP_Name")
	@Getter
	@Setter
	private String name;
	
	@Column(name="FUP_Nummer")
	
	private String FUPNo;

}
