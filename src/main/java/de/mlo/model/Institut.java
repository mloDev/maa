package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Institut.
 */
@Entity
@Table(name="tbl_Institut")
public class Institut {
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
