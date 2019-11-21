package cn.tedu.order.controller;

import java.util.List;

import com.fresh.common.pojo.Order;
import com.fresh.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.tedu.order.service.OrderService;

@RestController
@RequestMapping("order/manage")
public class OrderController {
	
	@Autowired
	 private OrderService orderService;
	/**
	 * 查询订单
	 * @param userId 用户ID
	 * @return  用户所有的订单
	 */
	@RequestMapping("query/{userId}")
	public List<Order> queryMyOrders(@PathVariable String userId){
		return orderService.queryMyOrders(userId);
	}

	/**
	 * 新增订单
	 */
	@RequestMapping("save")
	public SysResult addOrder(Order order){
		try{
			orderService.addOrder(order);
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201,"新增订单失败",null);
		}
	}
	@RequestMapping("delete/{orderId}")
	public SysResult deleteOrder(@PathVariable String orderId){
		try{
			orderService.deleteOrder(orderId);
			return SysResult.ok();
		}catch(Exception e){			
			e.printStackTrace();
			return SysResult.build(201,"删除订单失败",null);
		}
	}
}
