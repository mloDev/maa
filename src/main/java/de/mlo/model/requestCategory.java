package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class requestCategory.
 */
@Entity
public class requestCategory extends BaseEntity {

	/** The request category. */
	@Column
	
	/**
	 * Gets the request category.
	 *
	 * @return the request category
	 */
	@Getter
	
	/**
	 * Sets the request category.
	 *
	 * @param requestCategory the new request category
	 */
	@Setter
	private String requestCategory;
}
