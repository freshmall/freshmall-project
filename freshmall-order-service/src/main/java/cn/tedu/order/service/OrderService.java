package cn.tedu.order.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fresh.common.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.order.mapper.OrderMapper;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	public List<Order> queryMyOrders(String userId) {
		return orderMapper.selectOrderByUserId(userId);
	}

	public void addOrder(Order order) {
		//order对象缺少 order_id order_time Paystate(0)
		order.setOrderId(UUID.randomUUID().toString());
		order.setOrderTime(new Date());
		order.setOrderPaystate(0);
		orderMapper.insertOrderAndOrderItems(order);
	}

	public void deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		orderMapper.deleteOrder(orderId);
	}
	
}
