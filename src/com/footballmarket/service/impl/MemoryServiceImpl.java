package com.footballmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.footballmarket.entity.Memory;
import com.footballmarket.mapper.MemoryMapper;
import com.footballmarket.service.IMemoryService;

@Service
public class MemoryServiceImpl implements IMemoryService {
	@Autowired
	private MemoryMapper memoryMapper;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public List<Memory> finAllMemory() {
		return memoryMapper.findAllMemory();
	}

}
