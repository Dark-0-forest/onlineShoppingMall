package work.darkforest.acowzon.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.po.Goods;
import work.darkforest.acowzon.entity.po.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderId; // 订单id
    private String goodsId; // 商品id
    private String userId;  // 用户id
    private String retailerId;  // 商家id
    private int goodsCount; // 商品数量
    private double goodsPrice;  // 商品单价
    private double orderPrice;  // 订单价格
    private char orderState; // 订单状态 0未支付 1已支付 2未发货 3已发货 4已确认收货 5取消订单

    public OrderDto(Order order) {
        this.orderId = order.getOrderId();
        this.goodsId = order.getGoodsId();
        this.userId = order.getUserId();
        this.retailerId = order.getRetailerId();
        this.goodsCount = order.getGoodsCount();
        this.goodsPrice = order.getGoodsPrice();
        this.orderPrice = order.getOrderPrice();
        this.orderState = order.getOrderState();
    }

    public static List<OrderDto> toOrderDto(List<Order> orders){
        ArrayList<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(new OrderDto(order));
        }
        return orderDtos;
    }
}
