package com.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="gardshift_entity")
public class GardShiftEntity extends BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private long userId;
	private String name;
	private String time;
	private Date date;
	
	public GardShiftEntity()
		{}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	@Override
	public String toString() {
		return "GardShiftEntity [id=" + id + ", userId=" + userId + ", name=" + name + ", time=" + time + ", date="
				+ date + "]";
	}
	

	public GardShiftEntity(long id, long userId, String name, String time, Date date) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.time = time;
		this.date = date;
	}


	public GardShiftEntity(long userId, String name, String time, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.time = time;
		this.date = date;
	}


	@Override
	public String getKey() {

		return null;
	}

	@Override
	public String getValue() {

		return null;
	}

}
