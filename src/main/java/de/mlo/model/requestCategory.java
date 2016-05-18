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
 * The Class requestCategory.
 */
@Entity
@Table(name="tbl_AntragsKategorien")
public class requestCategory {
	
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
