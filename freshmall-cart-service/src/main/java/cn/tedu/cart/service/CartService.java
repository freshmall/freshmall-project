package cn.tedu.cart.service;

import java.util.List;

import com.fresh.common.pojo.Cart;
import com.fresh.common.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.tedu.cart.mapper.CartMapper;

@Service
public class CartService {
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private RestTemplate client;
	public List<Cart> queryMyCart(String userId) {
		// TODO Auto-generated method stub
		return cartMapper.selectCartByUserId(userId);
	}

	public void addMyCart(Cart cart) {
		/**
		 * 判断存在  userid productid
		 * 已经存在 增加数量 不存在补齐数据
		 */
	Cart exist=cartMapper.selectCartByUserIdAndProductId(cart);
	if(exist!=null){
		exist.setNum(exist.getNum()+cart.getNum());
		cartMapper.updateNumByUserIdAndProductId(exist);
	}else{
		/*
		 * 新增购物车
		 * 从商品系统利用productId	  
		 * 
		*/
		Product product = client.getForObject("http://productservice"+"/product/manage/detail/"+cart.getPid(), Product.class);
		cart.setPhyprice(product.getPhyprice());
        System.out.println(product.getPhyprice());
        cart.setPphoto(product.getPphoto());
        cart.setPname(product.getPname());
		cartMapper.insertCart(cart);
	}
	}

	public void updateCartNum(Cart cart) {
		cartMapper.updateNumByUserIdAndProductId(cart);	
	}
	
	public void deleteCart(Cart cart) {
		cartMapper.deleteByUserIdAndProductId(cart);
		
	}

}
