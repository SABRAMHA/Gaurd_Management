package com.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="gard_salary")
public class GardSalaryEntity extends BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
	private String userId;
	private long amount;
	private String status;
	private Date date;
	
	
	public GardSalaryEntity()
	{}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GardSalaryEntity [id=" + id + ", name=" + name + ", userId=" + userId + ", amount=" + amount
				+ ", status=" + status + ", date=" + date + "]";
	}

	
	public GardSalaryEntity(long id, String name, String userId, long amount, String status, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.amount = amount;
		this.status = status;
		this.date = date;
	}
	

	public GardSalaryEntity(String name, String userId, long amount, String status, Date date) {
		super();
		this.name = name;
		this.userId = userId;
		this.amount = amount;
		this.status = status;
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
