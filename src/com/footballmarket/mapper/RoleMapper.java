package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Funs;
import com.footballmarket.entity.Role;

@Repository
public interface RoleMapper {
	Role findById(Integer id);
	List<Role> findAllRole();
	Role findRolesFunsById(Integer roleId);
}
