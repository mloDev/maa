package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Title extends BaseEntity {
	
	@Column
	@Setter
	@Getter
	private String title;
	
	@Column
	@Setter
	@Getter
	private boolean degrade;

}
