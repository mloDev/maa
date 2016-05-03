package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Title.
 */
@Entity
public class Title extends BaseEntity {
	
	/** The title. */
	@Column
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	@Setter
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Getter
	private String title;
	
	/** The degrade. */
	@Column
	
	/**
	 * Sets the degrade.
	 *
	 * @param degrade the new degrade
	 */
	@Setter
	
	/**
	 * Checks if is degrade.
	 *
	 * @return true, if is degrade
	 */
	@Getter
	private boolean degrade;

}
