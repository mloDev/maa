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
 * The Class PLZCity.
 */
@Entity
@Table(name = "tbl_PLZ")
public class PLZCity {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "PLZ_ID")
	
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
	
	/** The plz. */
	@Column(name = "PLZ_PLZ", nullable = true)
	
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
	@Column(name = "PLZ_Ort", nullable = true)
	
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
