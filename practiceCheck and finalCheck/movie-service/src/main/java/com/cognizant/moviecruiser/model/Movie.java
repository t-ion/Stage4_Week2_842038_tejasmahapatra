package com.cognizant.moviecruiser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "title")
	private String title;

	@NotNull
	@Column(name = "boxoffice")
	private String boxOffice;

	@NotNull
	@Column(name = "active")
	private boolean active;

	@NotNull
	@Column(name = "dateoflaunch")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfLaunch;

	@NotNull
	@Column(name = "genre")
	private String genre;

	@NotNull
	@Column(name = "hasteaser")
	private boolean hasTeaser;
}