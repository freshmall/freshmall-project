package cn.tedu.order.mapper;

import java.util.List;

import com.fresh.common.pojo.Order;
import org.apache.ibatis.annotations.Param;


public interface OrderMapper {

	List<Order> selectOrderByUserId(String userId);

	void insertOrderAndOrderItems(Order order);

	void deleteOrder(String orderId);




    int queryTotalCount();
    int queryTotalCount2();
    List<Order> queryOrders(@Param("start")int start, @Param("rows")Integer rows);
    List<Order> queryProducts(@Param("start")int start, @Param("rows")Integer rows);

}
