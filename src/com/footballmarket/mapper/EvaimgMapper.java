package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Evaimg;

@Repository
public interface EvaimgMapper {
	Integer addEvaimg(Evaimg evaimg);
	Evaimg findEvaimgById(Integer id);
	List<Evaimg> findEvaimgByEvaId(Integer evaId);
}
