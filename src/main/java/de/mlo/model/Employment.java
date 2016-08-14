package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Employment.
 */
@Entity
@Table(name="tbl_AngestelltenVerhaeltnisse")
public class Employment{
	
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Getter
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	@Setter
	private String name;
	
	/** The desc. */
	@Column
	
	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	@Getter
	
	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	@Setter
	private String describtion;


}
