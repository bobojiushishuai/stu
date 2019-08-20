package com.jt.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest //包含包扫描  朱启东的操作
@RunWith(SpringRunner.class) //类加载机制 
public class TestMybatisPlus {
	@Autowired
	private UserMapper usermapper;
	
	@Test
	public void testSelectOne() {
		//根据主键查询数据库
		int id =25;
		User user = usermapper.selectById(id);
		System.out.println(user);
	
		//根据非主键查询   queyWrapper 条件构造器
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "菜徐昆");
		// select * from user where name="xxxx";
		User user2 = usermapper.selectOne(queryWrapper);
		System.out.println(user2);
	
	
	/**
	 * 查询多个数据
	 * = ：   eq
	 * > :  gt
	 * >= : ge
	 * < :  lt
	 * <= : le
	 * */
	
	QueryWrapper<User> qeryQueryWrapper = new QueryWrapper<>();
	queryWrapper.gt("age", "18")
				.eq("sex", "女");
	List<User> userAgeList = usermapper.selectList(queryWrapper);
	System.out.println(userAgeList);
	
	}	
	
	//用户更新操作 update
	//
	
	@Test
	public void testUpedateUser() {
		//1.利用主键更新  其余充当值
		User user = new User();
		user.setId(53).setName("贺毅")
			.setAge(250).setSex("女");
		int rows = usermapper.updateById(user);
		System.out.println("影响"+rows+"行！！！");
		
	
	
	//2.利用条件构造器  实现数据的更新
	/**
	 * 参数介绍：
	 * 1.entity 需要修改的数据
	 *
	 * 2.updateWrapper 更新的条件构造器
	 * 		可以为null  表示全表修改
	 *    	按照热定的规则编辑where条件
	 * 关于更新操作总结：
	 * 1.如果更新操作是根据主键更新 使用ById()
	 * 2.如果更新操作中有多个时或者更新没有主键是视同UpdateWRappre
	 * 
	 * */
	User user2 = new User();
	user2.setName("小达达")
		 .setAge(18)
		 .setSex("毛没长齐");
	UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",55);	
	int rows2 = usermapper.update(user2,updateWrapper);
	System.out.println("条件构造器更新"+rows2+"行成功！");
	
	/**
	 * 删除操作
	 * 需求1.删除id=53数据删除
	 * 需求2.
	 * 需求3.
	 * */
	
	
	
	
	
	
}	
}
