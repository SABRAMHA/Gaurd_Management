package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="security_entity")
public class SecurityEntity extends BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String message;
	private String alert;
	
	public SecurityEntity()
	{}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	

	@Override
	public String toString() {
		return "SecurityEntity [id=" + id + ", message=" + message + ", alert=" + alert + "]";
	}
	

	public SecurityEntity(long id, String message, String alert) {
		super();
		this.id = id;
		this.message = message;
		this.alert = alert;
	}
	



	public SecurityEntity(String message, String alert) {
		super();
		this.message = message;
		this.alert = alert;
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