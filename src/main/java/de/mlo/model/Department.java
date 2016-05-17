package de.mlo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String acronym;
}
