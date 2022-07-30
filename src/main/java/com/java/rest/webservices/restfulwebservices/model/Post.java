package com.java.rest.webservices.restfulwebservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String desc;

	private Date timestamp;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	protected Post() {
		super();
	}

	public Post(String name, String desc, Date timestamp) {
		super();
		this.name = name;
		this.desc = desc;
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", desc=" + desc + ", timestamp=" + timestamp + "]";
	}

}
