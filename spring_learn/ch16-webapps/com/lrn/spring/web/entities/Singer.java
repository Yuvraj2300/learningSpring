package com.lrn.spring.web.entities;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private String description;
	private byte photo;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Singer [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", description=" + description + ", photo=" + photo + "]";
	}

}
