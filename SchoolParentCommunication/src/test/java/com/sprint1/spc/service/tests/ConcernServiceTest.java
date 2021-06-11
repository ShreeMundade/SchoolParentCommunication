package com.sprint1.spc.service.tests;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.ConcernParty;
import com.sprint1.spc.entities.ConcernType;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.entities.User;
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

		Parent user = new Parent(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.PARENT);

		Teacher user1 = new Teacher(1l, "miser", "1234", 1245l, "miser@gmail.com", Role.TEACHER);

		Concern concern = new Concern(11l, "This Conrenc is regarding fees", true, "Fees is good", LocalDate.now(),
				user, user1, ConcernType.FEES_RELATED, ConcernParty.ACCOUNTANT);

		when(concernRepo.saveAndFlush(concern)).thenReturn(concern);

		Assertions.assertEquals(concern, concernService.addConcern(concern));

	}
}
