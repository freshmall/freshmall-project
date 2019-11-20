package cn.tedu.cart.mapper;

import com.fresh.common.pojo.Cart;

import java.util.List;


public interface CartMapper {

    List<Cart> selectCartsByUserId(String userId);

    Cart selectCartByUserIdAndProductId(Cart cart);

    void updateNumByUserIdAndProductId(Cart exist);

    void insertCart(Cart cart);

    void deleteCartByUserIdAndProductId(Cart cart);

}
