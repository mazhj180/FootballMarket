package com.footballmarket.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.footballmarket.entity.Order;
import com.footballmarket.util.OrderSearchVO;
import com.footballmarket.util.OrderVO;

@Repository
public interface OrderMapper {
	Order findOrderById(String orderId);
	Integer addOrder(Order order);
	Integer deleteOrder(String orderId);
	Integer payOrder(String orderId);
	Integer deliverOrder(String orderId,String expressNo);
	Integer receiveOrder(String orderId);
	Integer evaOrder(String orderId);
	List<Order> findAllOrder();
	List<Order> findAllOrderBySearchVO(OrderSearchVO vo);
	List<Order> findOrderByUser(Integer userId);
	List<Order> findOrderByUserAndState(Integer state,Integer userId);
	Integer updateOrder(Order order);
	List<OrderVO> findTotalMoneyByMonth(Integer limit);
	Integer findTotalOrder();
	Integer findTotalDeliverOrder();
}
