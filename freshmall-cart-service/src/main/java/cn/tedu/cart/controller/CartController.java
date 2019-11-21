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
    @Autowired
    private CartService cartService;

    //查询我的购物车
    @RequestMapping("query")
    public List<Cart> queryMycart(String userId){
        return cartService.queryMyCart(userId);
    }

    //新增我的购物车
    @RequestMapping("save")
    public SysResult addMyCart(Cart cart) {
        try {
            cartService.addMyCart(cart);
            return SysResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201, "新增失败了", null);
        }
    }

    //修改
    @RequestMapping("update")
    public SysResult modMyCart(Cart cart) {
        try {
            cartService.updateCartNum(cart);
            return SysResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201, "新增失败了", null);
        }
    }

    @RequestMapping("delete")
    public SysResult delMyCart(Cart cart) {
        try {
            cartService.deleteCart(cart);
            return SysResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201, "新增失败了", null);
        }
    }

}
