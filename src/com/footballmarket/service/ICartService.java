package com.footballmarket.service;

import java.util.List;

import com.footballmarket.entity.Cart;

public interface ICartService {
	Integer addGoodsToCart(Cart cart);
	Cart findCartByUserId(Integer userId,Integer goodsId);
	Integer updateCart(Cart cart);
	List<Cart> findCartByUserId(Integer userId);
	Integer deleteCart(Integer cartId);
	Cart findCartById(Integer cartId);
}
