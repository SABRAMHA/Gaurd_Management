package com.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="gardstranning_entity")
public class GardsTrainingEntity extends BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private long userId;
	private String name;
	private String mobileNo;
	private String status;
	private String timeing;
	private Date date;
	
	
	public GardsTrainingEntity()
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeing() {
		return timeing;
	}

	public void setTimeing(String timeing) {
		this.timeing = timeing;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String getKey() {

		return null;
	}

	

	@Override
	public String toString() {
		return "GardsTrainingEntity [id=" + id + ", userId=" + userId + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", status=" + status + ", timeing=" + timeing + ", date=" + date + "]";
	}

	public GardsTrainingEntity(long id, long userId, String name, String mobileNo, String status, String timeing,
			Date date) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timeing = timeing;
		this.date = date;
	}

	public GardsTrainingEntity(long userId, String name, String mobileNo, String status, String timeing, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timeing = timeing;
		this.date = date;
	}

	@Override
	public String getValue() {

		return null;
	}

}
