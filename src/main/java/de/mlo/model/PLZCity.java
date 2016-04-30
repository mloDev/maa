package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PLZCity extends BaseEntity {
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String plz;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String city;
	
	
}
