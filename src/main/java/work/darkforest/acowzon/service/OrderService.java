package work.darkforest.acowzon.service;

import org.apache.ibatis.annotations.Param;
import work.darkforest.acowzon.entity.dto.OrderDto;
import work.darkforest.acowzon.entity.po.Order;

import java.util.List;

public interface OrderService {
    // 查询所有的订单
    List<OrderDto> queryAllOrder();

    // 根据id查询订单
    OrderDto queryOrderById(String id);

    // 查询一个买家的所有订单
    List<OrderDto> queryOrderByBuyer(String id);

    // 查询一个卖家的所有订单
    List<OrderDto> queryOrderByRetailer(String id);

    // 根据用户id和商品id以及数量插入一个订单
    int addOrder(String userId, String goodsId, int count);

    // 修改订单的价格
    int updateOrderPrice(String id,double price);

    // 修改一个订单的状态
    Boolean updateOrderState(String id, String state);

    // 删除一个订单
    Boolean delOrderById(String id);
}