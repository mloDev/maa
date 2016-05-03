package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class PLZCity.
 */
@Entity
public class PLZCity extends BaseEntity {
	
	/** The plz. */
	@Column(nullable = true)
	
	/**
	 * Gets the plz.
	 *
	 * @return the plz
	 */
	@Getter
	
	/**
	 * Sets the plz.
	 *
	 * @param plz the new plz
	 */
	@Setter
	private String plz;
	
	/** The city. */
	@Column(nullable = true)
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	@Getter
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	@Setter
	private String city;
	
	
}
