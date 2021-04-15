package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.dto.OrderDto;
import work.darkforest.acowzon.entity.po.Goods;
import work.darkforest.acowzon.entity.po.Order;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.mapper.GoodsMapper;
import work.darkforest.acowzon.mapper.OrderMapper;
import work.darkforest.acowzon.mapper.UserMapper;
import work.darkforest.acowzon.service.OrderService;
import work.darkforest.acowzon.utils.constant.OrderStateConstant;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    UserMapper userMapper;


    @Override
    public List<OrderDto> queryAllOrder() {
        return OrderDto.toOrderDto(orderMapper.queryAllOrder());
    }

    @Override
    public OrderDto queryOrderById(String id) {
        Order order = orderMapper.queryOrderById(id);
        if (order == null){
            return null;
        } else {
            return new OrderDto(order);
        }
    }

    @Override
    public List<OrderDto> queryOrderByBuyer(String id) {
        return OrderDto.toOrderDto(orderMapper.queryOrderByBuyer(id));
    }

    @Override
    public List<OrderDto> queryOrderByRetailer(String id) {
        return OrderDto.toOrderDto(orderMapper.queryOrderByRetailer(id));
    }

    @Override
    public int addOrder(String userId, String goodsId, int count) {
        // 新建一个order对象
        Order order = new Order(goodsId, userId, count);
        User buyer = userMapper.queryUserById(userId);
        if (buyer == null){
            return -3;  // 买家未搜到
        } else if (buyer.getUserType() != '0'){
            return -4;  // 买家信息错误
        }
        // 获取商品信息
        Goods goods = goodsMapper.queryGoodsById(goodsId);
        User retailer = userMapper.queryUserById(goods.getRetailerId());
        if (goods == null){
            return -2;  // 商品不存在
        }
        if (retailer == null){
            return -5;  // 卖家信息不存在
        } else if (retailer.getUserType() != '1'){
            return -6;  // 卖家信息错误
        }
        order.setRetailerId(goods.getRetailerId());
        order.setGoodsPrice(goods.getGoodsPrice());
        order.setOrderPrice(count * order.getGoodsPrice());
        order.setOrderState(OrderStateConstant.ORDER_UNPAID);
        // 判断当前的库存容量是否足够
        System.out.println(order);
        if (count <= goods.getGoodsInventory()){
            // 先减少库存,再插入
            goodsMapper.updateInventory(goodsId, -count);
            // 0表示错误，1表示正确
            return orderMapper.addOrder(order);
        } else {
            return -1;  // 库存不够
        }
    }

    @Override
    public int updateOrderPrice(String id, double price) {
        Order order = orderMapper.queryOrderById(id);
        if (order.getOrderState() == '0'){  // 只有在未支付状态时才能改动订单的总价格
            // 0表示失败，1表示成功
            return orderMapper.updateOrderPrice(id, price);
        } else {
            return -1;
        }
    }

    @Override
    // 修改状态
    public Boolean updateOrderState(String id, String state) {
        switch (state){
            case "未支付":
                return orderMapper.updateOrderState(id, OrderStateConstant.ORDER_UNPAID) != 0;
            case "已支付":
                return orderMapper.updateOrderState(id, OrderStateConstant.ORDER_PAID) != 0;
            case "未发货":
                return orderMapper.updateOrderState(id, OrderStateConstant.ORDER_UNDELIVERED) != 0;
            case "已发货":
                return orderMapper.updateOrderState(id, OrderStateConstant.ORDER_DELIVERED) != 0;
            case "已收到":
                return orderMapper.updateOrderState(id, OrderStateConstant.ORDER_RECEIVED) != 0;
            case "取消":
                Order order = orderMapper.queryOrderById(id);
                if (order == null){
                    return false;
                }
                goodsMapper.updateInventory(order.getGoodsId(), order.getGoodsCount());
                return orderMapper.updateOrderState(id, OrderStateConstant.ORDER_CANCEL) != 0;
            default:
                return false;
        }
    }

    @Override
    public Boolean delOrderById(String id) {
        // 先判断此订单是否存在表中
        if (orderMapper.queryOrderById(id) == null){
            return false;
        }
        // 删除订单时，先把库存加回去
        Order order = orderMapper.queryOrderById(id);
        Goods goods = goodsMapper.queryGoodsById(order.getGoodsId());
        goodsMapper.updateInventory(goods.getGoodsId(), order.getGoodsCount());
        return orderMapper.delOrderById(id) != 0;
    }
}
