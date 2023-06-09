package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Cities;

@Repository
public interface CitiesMapper {
	List<Cities> findCitiesByProvinceId(String provinceId);
	Cities findCityByCityName(String name,String provinceId);
	Cities findCityById(String id);
}
