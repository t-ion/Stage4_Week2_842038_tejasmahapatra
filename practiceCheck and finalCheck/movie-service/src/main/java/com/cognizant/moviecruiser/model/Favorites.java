package com.cognizant.moviecruiser.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Favorites {

	public Favorites(int us_id, int mv_id) {
		super();
		this.us_id = us_id;
		this.mv_id = mv_id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column
	private int us_id;
	
	@NotNull
	@Column
	@JoinColumn(referencedColumnName = "mv_id")
	private int mv_id;
}
