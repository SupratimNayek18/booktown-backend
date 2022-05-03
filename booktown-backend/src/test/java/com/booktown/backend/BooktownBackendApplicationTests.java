package com.booktown.backend;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.booktown.backend.admin.controller.AdminEntryController;

@SpringBootTest
class BooktownBackendApplicationTests {

	@Autowired
	AdminEntryController adminEntryController;
	
	@Test
	void contextLoads() {
		assertNotNull(adminEntryController);
	}

}
