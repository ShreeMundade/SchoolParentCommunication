package com.sprint1.spc.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
	TEACHER, PARENT, STUDENT, ACCOUNTANT, ADMIN;
	
	@JsonCreator
	public static Role create(String value) {
		if (value == null) {
			return null;
		}
		for (Role role : values()) {
			if (value.equals(role.toString())) {
				return role;
			}
		}
		return null;
	}
	
}
