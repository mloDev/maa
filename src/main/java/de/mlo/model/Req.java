package de.mlo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Req extends BaseEntity {
	
	@Column
	@Setter
	@Getter
	private String name;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@Setter
	@Getter
	private Student student;

}
