package com.cognizant.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import lombok.Data;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Data
@Entity
public class Cart { 

	public Cart(int userId, int menuItemId) {
		this.us_id = userId;
		this.c_id = menuItemId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column
	private int us_id;
	
	
	@Column
	@JoinColumn(referencedColumnName = "c_id")
	private int c_id;
	
}