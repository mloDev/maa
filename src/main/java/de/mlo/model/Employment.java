package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Employment.
 */
@Entity
public class Employment extends BaseEntity{
	
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
	private String desc;


}
