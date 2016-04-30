package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public abstract class BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@Getter
	@Setter
	private int id;

}
