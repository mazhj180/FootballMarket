package com.footballmarket.service;

import java.util.List;

import com.footballmarket.entity.Banner;
import com.github.pagehelper.PageInfo;

public interface IBannerService {
	PageInfo<Banner> findAllBannerBySplitePage(Integer page,Integer limit,String keyword);
	List<Banner> findAllShowBanner();
	Integer updateBanner(Banner banner);
	Integer changeBannerState(Integer state,Integer bannerId);
	Integer deleteBanner(Integer bannerId);
	Integer addBanner(Banner banner);
}
