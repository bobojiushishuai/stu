package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;

//@Mapper 将Mapper接口交给Spring容器实例化.
//在底层
public interface UserMapper extends BaseMapper<User> {

	//查询数据库获取user信息
	@Select("select * from user")
	List<User> findAll();
	
	void insertUser(User user);
}
	