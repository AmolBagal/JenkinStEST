package com.yash.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import com.yash.model.User;
import com.yash.service.UserService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {

	@InjectMocks
	HelloWorldController helloWorldController;

	@Mock
	UserService userService;

	@Test
	public void shouldReturnRegisterString() {
		Map<String, Object> model = new HashMap<String, Object>();
		Assert.assertEquals("register", helloWorldController.register(model));

	}

	@Test
	public void shouldReturnSaveString() {

		ModelMap modelMap = new ModelMap();

		User user = new User();
		user.setUsername("Amol");

		Mockito.doNothing().when(userService).save(Mockito.any(User.class));

		Assert.assertEquals("Save", helloWorldController.save(user, modelMap));
	}
}
