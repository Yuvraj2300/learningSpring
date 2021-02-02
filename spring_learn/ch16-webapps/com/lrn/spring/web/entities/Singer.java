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
}
