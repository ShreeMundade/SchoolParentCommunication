package com.sprint1.spc.service.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.ConcernNotFoundException;
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

		Parent parent = new Parent(1l, "miser", "1234", "1245", "miser@gmail.com", Role.PARENT);

		Concern concern = new Concern(11l, "This Conrenc is regarding fees", LocalDate.now(), ConcernParty.TEACHER,
				parent, ConcernType.PERFORMANCE);

		Mockito.when(concernRepo.save(concern)).thenReturn(concern);

		Assertions.assertEquals(concern, concernService.addConcern(0, concern));

	}

	@Test
	public void resolveConcernTest() throws ConcernNotFoundException {

		Parent parent = new Parent(1l, "miser", "1234", "1245", "miser@gmail.com", Role.PARENT);

		Teacher teacher = new Teacher(1l, "miser", "1234", "1245", "miser@gmail.com", Role.TEACHER);

		Concern concern = new Concern(11l, "This Conrenc is regarding Performance", LocalDate.now(),
				ConcernParty.TEACHER, parent, ConcernType.PERFORMANCE);

		Concern concern1 = new Concern(11l, "This Conrenc is regarding Performance", true, "Fees is good",
				LocalDate.now(), LocalDate.now(), ConcernParty.TEACHER, parent, teacher, ConcernType.PERFORMANCE);

		Mockito.when(concernRepo.getById(concern.getConcernId())).thenReturn(concern1);

		Assertions.assertEquals(concern1, concernService.updateConcern(concern1));

	}
	@Test
	public void retriveAllConcernTest() throws ConcernNotFoundException {
		Parent parent = new Parent(1l, "miser", "1234", "1245", "miser@gmail.com", Role.PARENT);

		Teacher teacher = new Teacher(1l, "miser", "1234", "1245", "miser@gmail.com", Role.TEACHER);

		List<Concern> concernList=new ArrayList<Concern>();
		concernList.add(new Concern(11l, "This Conrenc is regarding Performance", true, "Fees is good", LocalDate.now(),LocalDate.now(),ConcernParty.TEACHER,parent, teacher, ConcernType.PERFORMANCE));
		concernList.add(new Concern(12l, "This Conrenc is regarding Attendance", true, "Attendence is good", LocalDate.now(),LocalDate.now(),ConcernParty.TEACHER,parent, teacher, ConcernType.ATTENDANCE));
		assertNotNull(parent);
		assertNotNull(teacher);
		
		Mockito.when(concernRepo.findAll()).thenReturn(concernList);
		List<Concern> concernlist = concernService.retrieveAllConcerns();
		assertNotNull(concernlist);
		
	}

//	@Test
//	public void retriveAllConcernByParentTest() throws ConcernNotFoundException {
//		Parent parent = new Parent(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.PARENT);
//
//		Teacher teacher = new Teacher(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.TEACHER);
//
//		List<Concern> concernList=new ArrayList<Concern>();
//		concernList.add(new Concern(11l, "This Conrenc is regarding Performance", true, "Fees is good", LocalDate.now(),LocalDate.now(),ConcernParty.TEACHER,parent, teacher, ConcernType.PERFORMANCE));
//		concernList.add(new Concern(12l, "This Conrenc is regarding Attendance", true, "Attendence is good", LocalDate.now(),LocalDate.now(),ConcernParty.TEACHER,parent, teacher, ConcernType.ATTENDANCE));
//		assertNotNull(parent);
//		assertNotNull(teacher);
//		
//		Mockito.when(concernRepo.findAll()).thenReturn(concernList);
//		List<Concern> concernlist = concernService.retrieveAllConcernsByParentId(parent.getId());
//		assertNotNull(concernlist);
//		
//	}

	

}
