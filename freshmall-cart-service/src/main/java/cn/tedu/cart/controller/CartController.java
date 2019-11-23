package cn.tedu.cart.controller;



import java.util.List;

import com.fresh.common.pojo.Cart;
import com.fresh.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.tedu.cart.service.CartService;


@RestController
@RequestMapping("cart/manage")
public class CartController {
	/**
	 * 查询购物车
	 */
	@Autowired
	private CartService cartService;
	
	@RequestMapping("query")
	public List<Cart> queryMyCart(String userId){
		return cartService.queryMyCart(userId);
	}
	/**
	 * 新增购物车
	 */
	@RequestMapping("save")
	public SysResult addMyCart(Cart cart){
		try{
			cartService.addMyCart(cart);
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201,"新增失败", null);
		}
	}
	@RequestMapping("update")
	public SysResult updateCartNum(Cart cart){
		try{
			cartService.updateCartNum(cart);
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201,"更新失败", null);
		}
	}
	/**
	 * 删除购物车
	 */
	@RequestMapping("delete")
	public SysResult deleteCart(Cart cart){
		try{
			cartService.deleteCart(cart);
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201,"删除失败", null);
		}
	}
}
