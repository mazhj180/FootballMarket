package com.footballmarket.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Cart;

@Repository
public interface CartMapper {
	Cart findCartById(Integer id);
	Integer addCart(Cart cart);
	Integer deleteCart(Integer cartId);
	Integer updateCart(Cart cart);
	List<Cart> findCartListByUserId(Integer userId);
	Cart findCartByUserId(Integer userId,Integer goodsId);
}
