package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Users;

@Repository
public interface UserMapper {
	Users findUserById(Integer userId);
	Integer addUser(Users user);
	Integer deleteUser(Integer userId);
	Integer changeUserState(Integer state,Integer userId);
	Integer updateUser(Users user);
	List<Users> findAllUser();
	List<Users> findUserByName(String name);
	List<Users> findUserByphone(String phone);
	List<Users> findAllUserLikeName(String name);
}
