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
    private RestTemplate client;

    @Autowired
    private CartMapper cartMapper;

    public List<Cart> queryMyCart(String userId) {
        return cartMapper.selectCartsByUserId(userId);
    }

    public void addMyCart(Cart cart) {
        Cart exist = cartMapper.selectCartByUserIdAndProductId(cart);
        //存在则更新
        if(exist!=null) {
            //update t_cart set num=#{num} user_id=#{userId} product_id=
            exist.setNum(exist.getNum()+cart.getNum());
            cartMapper.updateNumByUserIdAndProductId(exist);
        }else {
            //从商品系统
            Product product = client.getForObject("http://productservice/product/manage/item/"+cart.getPid(), Product.class);
            cart.setPscprice(product.getPscprice());
            cart.setPphoto(product.getPphoto());
            cart.setPname(product.getPname());
            cartMapper.insertCart(cart);
        }
    }


    public void updateCartNum(Cart cart) {
        cartMapper.updateNumByUserIdAndProductId(cart);
    }

    public void deleteCart(Cart cart) {
        cartMapper.deleteCartByUserIdAndProductId(cart);
    }

}
