package com.sprint1.spc.entity.tests;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sprint1.spc.entities.Attendance;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttendanceTest {
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void crudOperations()
	{
		final Attendance attendance=new Attendance();
		attendance.setDateOfClass(LocalDate.parse("2021-06-05"));
		attendance.setPresent(false);
		
		entityManager.persist(attendance);
		
		final List<Attendance> listOfAttendance = entityManager.createQuery("select a from Attendance a", Attendance.class).getResultList();
		
		Assertions.assertEquals(7, listOfAttendance.size());
	}
	
}

