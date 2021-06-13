package com.sprint1.spc.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Attendance")
public class Attendance {

	@Id
	@SequenceGenerator(name = "AttencenceIdGeneration", initialValue = 1001, allocationSize = 995)
	@GeneratedValue(generator = "AttencenceIdGeneration")
	private long attendanceId;
	private LocalDate dateOfClass;
	private boolean present;

	public long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public LocalDate getDateOfClass() {
		return dateOfClass;
	}

	public void setDateOfClass(LocalDate dateOfClass) {
		this.dateOfClass = dateOfClass;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Attendance(long attendanceId, LocalDate dateOfClass, boolean present) {
		super();
		this.attendanceId = attendanceId;
		this.dateOfClass = dateOfClass;
		this.present = present;
	}

	public Attendance(LocalDate dateOfClass, boolean present) {
		super();
		this.dateOfClass = dateOfClass;
		this.present = present;
	}

	public Attendance() {
		super();

	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", dateOfClass=" + dateOfClass + ", present=" + present
				+ "]";
	}


}