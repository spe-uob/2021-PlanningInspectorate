package com.planningInspectorate;

import com.planningInspectorate.DataLayer.CompleteRecord;
import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
}
