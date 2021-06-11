package com.sprint1.spc.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ConcernType {
	ACADEMIC, ATTENDANCE, PERFORMANCE, FEES_RELATED, TRANSPORT, MESS, EXAM, TRANSFER;
	
	@JsonCreator
	public static ConcernType create(String value) {
		if (value == null) {
			return null;
		}
		for (ConcernType concernType : values()) {
			if (value.equals(concernType.toString())) {
				return concernType;
			}
		}
		return null;
	}
}
