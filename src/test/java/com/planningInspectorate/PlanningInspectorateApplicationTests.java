package com.planningInspectorate;

import com.planningInspectorate.DataLayer.CompleteRecord;
import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanningInspectorateApplicationTests {

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
	void b_testRead(){}

	@Test
	void c_testUpdate(){}

	@Test
	void d_testDelete(){}
}
