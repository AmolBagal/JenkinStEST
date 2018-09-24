package com.yash.dao;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.model.User;

@Repository
public class UserDao {

	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }
	@Autowired
	JdbcTemplate jdbcTemplate; 

	public void save(User user) { 
		String sql = "insert into user values('" + user.getUsername() + "','" + user.getPassword() + "','"
				+ user.getEmail() + "'," + user.getId() + ",'" + user.getProfession() + "')";
		jdbcTemplate.update(sql);
	} 

}
