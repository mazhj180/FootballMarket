package com.footballmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballmarket.entity.Address;
import com.footballmarket.entity.Areas;
import com.footballmarket.entity.Cities;
import com.footballmarket.entity.Provinces;
import com.footballmarket.mapper.AddressMapper;
import com.footballmarket.mapper.AreasMapper;
import com.footballmarket.mapper.CitiesMapper;
import com.footballmarket.mapper.ProvincesMapper;
import com.footballmarket.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private ProvincesMapper proMapper;
	@Autowired
	private CitiesMapper cityMapper;
	@Autowired
	private AreasMapper areaMapper;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public List<Address> findAddressByUserId(Integer userId) {
		return addressMapper.findAddrByUserId(userId);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public Address findAddresById(Integer id) {
		return addressMapper.findAddrById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public Provinces findProByProByName(String name) {
		return proMapper.findProByProName(name);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public Cities findCityByCityName(String name,String provinceId) {
		return cityMapper.findCityByCityName(name,provinceId);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public Areas findAreaByAreaName(String name,String cityId) {
		return areaMapper.findAreaByAreaName(name,cityId);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public Integer addAddress(Address addr) {
		return addressMapper.addAddress(addr);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public Integer updateAddress(Address addr) {
		return addressMapper.updateAddr(addr);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public Integer deleteAddress(Integer addrId) {
		return addressMapper.deleteAddr(addrId);
	}
	
}
