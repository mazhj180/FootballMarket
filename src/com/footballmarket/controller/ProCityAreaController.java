package com.footballmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.footballmarket.entity.Areas;
import com.footballmarket.entity.Cities;
import com.footballmarket.entity.Provinces;
import com.footballmarket.service.IProCityAreaService;

@Controller
@RequestMapping("/proCityArea")
public class ProCityAreaController {
	@Autowired
	private IProCityAreaService service;
	
	@RequestMapping("findAllPro")
	@ResponseBody
	public List<Provinces> findAllProvinces(){
		return service.findAllProvinces();
	}
	@RequestMapping("findCityByProId")
	@ResponseBody
	public List<Cities> findCityByProviceId(String provinceId){
		return service.findCityByProvincesId(provinceId);
	}
	@RequestMapping("findAreaByCityId")
	@ResponseBody
	public List<Areas> findAreaByCityId(String cityId){
		return service.findAreaByCityId(cityId);
	}
}
