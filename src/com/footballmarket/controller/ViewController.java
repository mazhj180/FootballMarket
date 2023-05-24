package com.footballmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@RequestMapping("goodsList")
	public String pathControl(){
		return "admin/goodslist";
	}
	@RequestMapping("kucunList")
	public String kucunControl(){
		return "admin/kucunlist";
	}
	@RequestMapping("addGoods")
	public String toAddGoods(){
		return "admin/goodsadd";
	}
	@RequestMapping("login")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("register")
	public String toRegister(){
		return "register";
	}
	@RequestMapping("usercenter")
	public String toUserCenter(){
		return "userview/usercenter";
	}
	@RequestMapping("index")
	public String toIndex(){
		return "index";
	}
	@RequestMapping("xieyi")
	public String xieyi(){
		return "xieyi";
	}
	@RequestMapping("cart")
	public String toCart(){
		return "userview/shopping_cart";
	}
	@RequestMapping("admin")
	public String toAdmin(){
		return "adminlogin";
	}
	@RequestMapping("orderlist")
	public String toOrderList(){
		return "admin/orderlist";
	}
	@RequestMapping("orderlistbyfh")
	public String toOrderListbyfh(){
		return "admin/orderlistbyfh";
	}
	@RequestMapping("userlist")
	public String toUserList(){
		return "admin/userlist";
	}
	@RequestMapping("passlist")
	public String toPassList(){
		return "admin/passlist";
	}
	@RequestMapping("bannerlist")
	public String toBannerList(){
		return "admin/bannerlist";
	}
	@RequestMapping("addbanner")
	public String toAddBanner(){
		return "admin/banneradd";
	}
	@RequestMapping("evaluate")
	public String toEva(){
		return "userview/evaluate";
	}
	@RequestMapping("evalist")
	public String toEvalist(){
		return "admin/evalist";
	}
	@RequestMapping("welcome")
	public String toWelcome(){
		return "admin/welcome";
	}
	@RequestMapping("toAdminIndex")
	public String toAdminIndex(){
		return "admin/index";
	}
	@RequestMapping("admininfo")
	public String adminInfo(){
		return "admin/info";
	}
	@RequestMapping("updatepass")
	public String updatePass(){
		return "admin/updatepass";
	}
	@RequestMapping("typelist")
	public String toTypeList(){
		return "admin/typelist";
	}
}
