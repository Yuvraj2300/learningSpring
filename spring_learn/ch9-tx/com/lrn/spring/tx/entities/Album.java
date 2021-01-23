package com.lrn.spring.tx.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "album")
public class Album implements Serializable {
	public Album() {
		// needed byJPA
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Version
	@Column(name = "VERSION")
	private int version;
	@Column
	private String title;

	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	@ManyToOne
	@JoinColumn(name = "SINGER_ID")
	private Singer singer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Album - Id: " + id + ", Title: " + title + ", Release Date: " + releaseDate + " by : "
				+ singer.getFirstName() + " " + singer.getLastName();
	}
}
