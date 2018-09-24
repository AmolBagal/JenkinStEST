package com.yash.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yash.model.User;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

	@InjectMocks
	UserDao userDao; 

	@Mock
	JdbcTemplate jdbcTemplate;

	@Test
	public void shouldCallUpdateAtLeastOneTime() {

		User user = new User();
		user.setUsername("amol");
		user.setPassword("bagal");
		user.setId(10);
		user.setEmail("Amol@gmail.com");
		user.setProfession("Developer");

		String sql = "insert into user values('" + user.getUsername() + "','" + user.getPassword() + "','"
				+ user.getEmail() + "'," + user.getId() + ",'" + user.getProfession() + "')";

		Mockito.when(jdbcTemplate.update(Mockito.anyString())).thenReturn(1);

		userDao.save(user);

		Mockito.verify(jdbcTemplate).update(sql);
	}

}
