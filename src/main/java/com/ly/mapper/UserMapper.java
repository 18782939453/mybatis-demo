package com.ly.mapper;

import com.ly.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author qwe
 */
public interface UserMapper {

	/**
	 * 插入一条新的user
	 * @param name
	 * @param password
	 * @param phone
	 * @return
	 */
	@SelectKey(statement="select replace(UUID(),'-','') as id", keyProperty="id", before=true, statementType=StatementType.STATEMENT,resultType=String.class)
	@Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE,id) VALUES(#{name}, #{password}, #{phone},#{id})")
	int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

	/**
	 * 根据电话号码查询
	 * @param phone
	 * @return
	 */
	@Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
	User findUserByPhone(@Param("phone") String phone);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@Delete("delete FROM T_USER where id = #{id}")
	int deleteById(@Param("id") String id);
}
