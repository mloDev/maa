package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Employment extends BaseEntity{
	
	@Column
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String desc;


}
