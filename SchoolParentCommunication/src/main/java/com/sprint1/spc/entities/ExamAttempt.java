package com.sprint1.spc.entities;

import javax.persistence.Embeddable;

@Embeddable
public class ExamAttempt {

	private boolean attempted;
	private int marksObtained;

	public ExamAttempt() {
		super();

	}

	public boolean isAttempted() {
		return attempted;
	}

	public void setAttempted(boolean attempted) {
		this.attempted = attempted;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	public ExamAttempt(boolean attempted, int marksObtained) {
		super();
		this.attempted = attempted;
		this.marksObtained = marksObtained;
	}

	public ExamAttempt(int marksObtained) {
		super();
		this.marksObtained = marksObtained;
	}

	@Override
	public String toString() {
		return "ExamAttempt [attempted=" + attempted + ", marksObtained=" + marksObtained + "]";

	}

}