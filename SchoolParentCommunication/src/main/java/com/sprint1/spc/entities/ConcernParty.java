package com.sprint1.spc.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ConcernParty {
	TEACHER, ACCOUNTANT, PRINCIPLE, TRANSPORT_OFFICER, CATERER;

	@JsonCreator
	public static ConcernParty create(String value) {
		if (value == null) {
			return null;
		}
		for (ConcernParty concernParty : values()) {
			if (value.equals(concernParty.toString())) {
				return concernParty;
			}
		}
		return null;
	}
}