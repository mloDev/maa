package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Institut extends BaseEntity {
	
	@Column
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String shortName;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String instNo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private PLZCity plzCity;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String street;
	
}
