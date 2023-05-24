package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Memory;

@Repository
public interface MemoryMapper {
	Memory findMemoryById(Integer id);
	List<Memory> findAllMemory();
}
