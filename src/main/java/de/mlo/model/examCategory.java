package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class examCategory.
 */
@Entity
public class examCategory extends BaseEntity {
	
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

}
