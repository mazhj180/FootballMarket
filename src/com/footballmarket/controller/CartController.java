package com.footballmarket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.footballmarket.entity.Address;
import com.footballmarket.entity.Cart;
import com.footballmarket.entity.Goods;
import com.footballmarket.entity.Users;
import com.footballmarket.service.IAddressService;
import com.footballmarket.service.ICartService;
import com.footballmarket.service.IGoodsService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping("addCart")
	@ResponseBody
	public String addToCart(Integer goodsId,Integer num,HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		Cart cart = cartService.findCartByUserId(user.getUserId(), goodsId);
		if(cart!=null){
			cart.setCartNum(cart.getCartNum()+num);
			cartService.updateCart(cart);
		}else{
			Goods goods = goodsService.findById(goodsId);
			Cart c=new Cart(goods, num, goods.getGoodsPrice(), user);
			cartService.addGoodsToCart(c);
		}
		return "success";
	}
	@RequestMapping("findCartByUser")
	@ResponseBody
	public List<Cart> findCartByUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		List<Cart> list = cartService.findCartByUserId(user.getUserId());
		return list;
	}
	
	@RequestMapping("deleteCart")
	@ResponseBody
	public String deleteCart(Integer cartId){
		Integer rs = cartService.deleteCart(cartId);
		if(rs>0){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping("reduceCartNum")
	@ResponseBody
	public String reduceCartNum(Integer cartId){
		Cart cart = cartService.findCartById(cartId);
		cart.setCartNum(cart.getCartNum()-1);
		Integer rs = cartService.updateCart(cart);
		if(rs>0){
			return "success";
		}else{
			return "fail";
		}
	}
	@RequestMapping("addCartNum")
	@ResponseBody
	public String addCartNum(Integer cartId){
		Cart cart = cartService.findCartById(cartId);
		cart.setCartNum(cart.getCartNum()+1);
		Integer rs = cartService.updateCart(cart);
		if(rs>0){
			return "success";
		}else{
			return "fail";
		}
	}
	@RequestMapping("preOrder")
	public String preOrder(Integer[] goodslist,Model model,HttpServletRequest request){
		List<Cart> cartList=new ArrayList<Cart>();
		for (Integer i : goodslist) {
			Cart cart = cartService.findCartById(i);
			cartList.add(cart);
		}
		model.addAttribute("cartList", cartList);
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		List<Address> addrList = addressService.findAddressByUserId(user.getUserId());
		model.addAttribute("addrList", addrList);
		return "userview/confirm_order";
	}
}
