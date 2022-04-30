package com.planningInspectorate;

import com.planningInspectorate.DataLayer.*;
import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import com.planningInspectorate.ServiceLayer.oneTimePinUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
class PlanningInspectorateApplicationTests {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private OrganisationRepository organisationRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private UpdateRecordRepository updateRecordRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void a_testInsert(){
		databaseCrudLogic crud = new databaseCrudLogic();
		CompleteRecord record = new CompleteRecord("department", "organisation", "test", "notes", "method", "name", "email");
		boolean complete = crud.AddRecord(record);
		assert complete;
	}

	@Test
	void b_testRead(){
		databaseCrudLogic crud = new databaseCrudLogic();
		boolean complete = crud.GetRecords("department") != null;

		assert complete;
	}

	@Test
	void c_testUpdate(){
		databaseCrudLogic crud = new databaseCrudLogic();
		CompleteRecord record = new CompleteRecord("department2", "organisation", "test", "notes", "method", "name", "email");
		boolean complete = crud.EditRecord(record);

		assert complete;
	}

	@Test
	void d_testDelete(){
		databaseCrudLogic crud = new databaseCrudLogic();
		String id = crud.GetRecords("department2")[0].getId();
		boolean complete = crud.DeleteRecord(id);

		assert complete;
	}

	@Test
	void c_testSHA256Hashing() throws NoSuchAlgorithmException {
		oneTimePinUtil otpgen = new oneTimePinUtil();
		String otp = otpgen.GenerateOneTimePinHashFromId("12345");

		boolean complete = otp != "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5";


		assert complete;

	}

}