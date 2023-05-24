package com.footballmarket.service;

import java.util.List;

import com.footballmarket.entity.GoodsType;
import com.github.pagehelper.PageInfo;

public interface IGoodsTypeService {
	List<GoodsType> findAllType();
	
	PageInfo<GoodsType> findTypeBySplitPage(Integer page,Integer limit,String keyword);
	Integer updateGoodsType(GoodsType type);
	Integer addGoodsType(GoodsType type);
	Integer changeTypeState(Integer state,Integer typeId);
	Integer deleteGoodsType(Integer typeId);
}
