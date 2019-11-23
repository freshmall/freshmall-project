package cn.tedu.cart.mapper;


import com.fresh.common.pojo.Cart;

import java.util.List;

public interface CartMapper {

	List<Cart> selectCartByUserId(String userId);

	void insertCart(Cart cart);

	void updateNumByUserIdAndProductId(Cart exist);

	Cart selectCartByUserIdAndProductId(Cart cart);

	void deleteByUserIdAndProductId(Cart cart);

}
