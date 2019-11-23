package cn.tedu.order.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fresh.common.pojo.Order;
import com.fresh.common.vo.EasyUIResult;
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



    public EasyUIResult queryOrdersByPage(Integer page, Integer rows) {
        //准备EasyUIResult对象
        EasyUIResult result =new EasyUIResult();

        //封装总数 select count(order_id) from t_order
        int total=orderMapper.queryTotalCount();
        result.setTotal(total);//total是js计算显示页数
        //total%rows==0? allPages=total/rows:(total/rows)+1
        //查询的页数page rows和sql语句执行的条件封装有关
        //传递2个值，一个start起始下标 rows查询条数 start=(page-1)*rows
        int start=(page-1)*rows;
        List<Order> pList=orderMapper.queryOrders(start,rows);
        result.setRows(pList);
        return result;
    }

    public EasyUIResult queryOrdersByPage2(Integer page, Integer rows) {
        //准备EasyUIResult对象
        EasyUIResult result =new EasyUIResult();

        //封装总数 select count(pname) from order_item
        int total=orderMapper.queryTotalCount2();
        result.setTotal(total);//total是js计算显示页数
        //total%rows==0? allPages=total/rows:(total/rows)+1
        //查询的页数page rows和sql语句执行的条件封装有关
        //传递2个值，一个start起始下标 rows查询条数 start=(page-1)*rows
        int start=(page-1)*rows;
        List<Order> pList=orderMapper.queryProducts(start,rows);
        result.setRows(pList);
        return result;
    }
}
