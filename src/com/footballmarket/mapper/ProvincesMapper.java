package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Address;
import com.footballmarket.entity.Provinces;

@Repository
public interface ProvincesMapper {
	List<Provinces> findAllProvince();
	Provinces findProByProName(String name);
	Provinces findProByProId(String id);
}
