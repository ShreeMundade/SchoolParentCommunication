package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.ConcernParty;
import com.sprint1.spc.entities.ConcernType;
import com.sprint1.spc.entities.Exam;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.ConcernNotFoundException;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.services.ConcernServiceImpl;

class ConcernServiceTest {
	@InjectMocks

	@Autowired
	private ConcernServiceImpl concernService;

	@Mock
	private IConcernRepository concernRepo;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void createConcernTest() {

		Parent parent = new Parent(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.PARENT);

		Concern concern = new Concern(11l, "This Conrenc is regarding fees", LocalDate.now(), ConcernParty.TEACHER,
				parent, ConcernType.PERFORMANCE);

		Mockito.when(concernRepo.saveAndFlush(concern)).thenReturn(concern);

		Assertions.assertEquals(concern, concernService.addConcern(concern));

	}

	@Test
	public void resolveConcernTest() throws ConcernNotFoundException {

		Parent parent = new Parent(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.PARENT);

		Teacher teacher = new Teacher(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.TEACHER);

		Concern concern = new Concern(11l, "This Conrenc is regarding Performance", LocalDate.now(), ConcernParty.TEACHER,
				parent, ConcernType.PERFORMANCE);

	
		Concern concern1 = new Concern(11l, "This Conrenc is regarding Performance", true, "Fees is good", LocalDate.now(),LocalDate.now(),ConcernParty.TEACHER,parent, teacher, ConcernType.PERFORMANCE);
		
		Mockito.when(concernRepo.getById(concern.getConcernId())).thenReturn(concern1);

		Assertions.assertEquals(concern1, concernService.updateConcern(concern1));

	}
}
