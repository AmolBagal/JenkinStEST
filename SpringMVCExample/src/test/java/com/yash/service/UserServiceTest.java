package com.yash.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.UserDao;
import com.yash.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserDao userDao;

	@Test
	public void saveShouldCallAtleastOne() {
		User user = new User();

		Mockito.doNothing().when(userDao).save(Mockito.any(User.class));

		userService.save(user);

		Mockito.verify(userDao).save(user);
	}
}
