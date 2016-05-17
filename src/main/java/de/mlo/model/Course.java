package de.mlo.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Course extends BaseEntity {
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String acronym;
	
	

}
