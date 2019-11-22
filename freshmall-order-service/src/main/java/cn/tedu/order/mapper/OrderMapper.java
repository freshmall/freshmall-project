package cn.tedu.order.mapper;

import java.util.List;

import com.fresh.common.pojo.Order;

public interface OrderMapper {

	List<Order> selectOrderByUserId(String userId);

	void insertOrderAndOrderItems(Order order);

	void deleteOrder(String orderId);


}
