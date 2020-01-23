package com.forkalau.lmsjava;


import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.repositories.IUserRepository;
import com.forkalau.lmsjava.services.UserService;
import com.forkalau.lmsjava.services.iservices.IFactory;
import com.forkalau.lmsjava.services.middlewares.logs.IWriteLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {
	@Mock
	private IUserRepository userRepository;
	@Mock
	private IFactory factory;
	@Mock
	private IWriteLog writeLog;
	@InjectMocks
	UserService service;

	User user = new User();

	@BeforeEach
	void setUp() {
		user.setName("Martin");
		user.setBarcode("123456");
		user.setMemberType("Staff");
		user.setId(Long.valueOf(1));
	}

	@Test
	void testSave () {
		service.saveOrUpdateUser(user);
		verify(userRepository).save(user);
	}

}