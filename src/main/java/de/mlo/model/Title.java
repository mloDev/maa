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
 * The Class Title.
 */
@Entity
@Table(name="tbl_AkademischeGrad")
public class Title {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "AG_ID")
	
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
	
	/** The title. */
	@Column(name="AG_Name")
	
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
	private String name;
	
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
