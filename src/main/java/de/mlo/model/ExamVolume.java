package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_PrfgsUmfang")
public class ExamVolume {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "STD_ID")
	
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
	
	@Column(name="STD_SWS")
	@Getter
	@Setter
	private String stdSws;
	
	@Column(name="STD_SWS_Anzahl")
	@Getter
	@Setter
	private int stdSwsAnzahl;

}
