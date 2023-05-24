package com.footballmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.footballmarket.entity.Address;
import com.footballmarket.entity.Areas;
import com.footballmarket.entity.Cities;
import com.footballmarket.entity.Provinces;

public interface IAddressService {
	List<Address> findAddressByUserId(Integer userId);
	Address findAddresById(Integer id);
	Provinces findProByProByName(String name);
	Cities findCityByCityName(String name,String provinceId);
	Areas findAreaByAreaName(String name,String cityId);
	Integer addAddress(Address addr);
	Integer updateAddress(Address addr);
	Integer deleteAddress(Integer addrId);
}
