package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Restrictions.
 */
@Entity
public class Restrictions extends BaseEntity {

	/** The restrictions category. */
	@Column
	
	/**
	 * Gets the restrictions category.
	 *
	 * @return the restrictions category
	 */
	@Getter
	
	/**
	 * Sets the restrictions category.
	 *
	 * @param restrictionsCategory the new restrictions category
	 */
	@Setter
	private String restrictionsCategory;
	
}
