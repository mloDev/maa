package de.mlo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Req extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8115733602274019649L;



	@Column
	@Setter
	@Getter
	private String name;

	@Setter
	private Student student;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student")
	public Student getStudent() {
		return this.student;
		
	}
	

}
