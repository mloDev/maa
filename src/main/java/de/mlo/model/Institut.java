package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Institut.
 */
@Entity
public class Institut extends BaseEntity {
	
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
	
	/** The short name. */
	@Column(nullable = true)
	
	/**
	 * Gets the short name.
	 *
	 * @return the short name
	 */
	@Getter
	
	/**
	 * Sets the short name.
	 *
	 * @param shortName the new short name
	 */
	@Setter
	private String shortName;
	
	/** The inst no. */
	@Column(nullable = true)
	
	/**
	 * Gets the inst no.
	 *
	 * @return the inst no
	 */
	@Getter
	
	/**
	 * Sets the inst no.
	 *
	 * @param instNo the new inst no
	 */
	@Setter
	private String instNo;
	
	/** The plz city. */
	@OneToOne(fetch = FetchType.LAZY)
	
	/**
	 * Gets the plz city.
	 *
	 * @return the plz city
	 */
	@Getter
	
	/**
	 * Sets the plz city.
	 *
	 * @param plzCity the new plz city
	 */
	@Setter
	private PLZCity plzCity;
	
	/** The street. */
	@Column(nullable = true)
	
	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	@Getter
	
	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	@Setter
	private String street;
	
}
