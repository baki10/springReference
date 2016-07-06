package com.bakigoal.dao.entity;

import com.bakigoal.dao.base.VersionedEntity;

import javax.persistence.Entity;

/**
 * Created by ilmir on 02.06.16.
 */
@Entity
public class Player extends VersionedEntity {

	private String firstName;
	private String lastName;
	private Integer number;

	public Player() {
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
