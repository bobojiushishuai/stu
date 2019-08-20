package com.jt.test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringBoot {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 1.查询user表的记录
	 */
	@Test
	public void testFind() {
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
		System.out.println("获取代理对象的类型:"+userMapper.getClass());
	}
	
	/**
	 * mybatis新增user
	 */
	@Test
	public void insertUser() {
		User user = new User();
		user.setId(null).setName("孙扬")
		.setAge(25).setSex("娘们");
		userMapper.insertUser(user);
		System.out.println("入库成功!!!!");
	}
	
	@Test
	public void insert() {
		User user = new User();
		user.setId(null)
			.setName("mybatisplus入库！！")
			.setAge(3)
			.setSex("男");
		userMapper.insert(user);
		System.out.println("执行成功！");
			
		
	}
	
	
	
	
	
	
	
}
