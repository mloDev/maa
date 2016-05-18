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
 * The Class Restrictions.
 */
@Entity
@Table(name="tbl_Auflagen")
public class Restrictions {
	
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
