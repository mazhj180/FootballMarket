package com.footballmarket.service;

import java.util.List;

import com.footballmarket.entity.Areas;
import com.footballmarket.entity.Cities;
import com.footballmarket.entity.Provinces;

public interface IProCityAreaService {
	List<Provinces> findAllProvinces();
	List<Cities> findCityByProvincesId(String provinceId);
	List<Areas> findAreaByCityId(String cityId);
	Provinces findProvinceById(String id);
	Cities findCityById(String id);
	Areas findAreaById(String id);
	Provinces findProvinceByName(String name);
	Cities findCityByName(String name,String provinceId);
	Areas findAreaByName(String name,String cityId);
}
