package com.footballmarket.service;

import com.footballmarket.entity.Admins;

public interface IAdminService {
	Admins login(String name,String pass);
	Integer updateAdmin(Admins admin);
	Admins findAdminById(Integer id);
}
