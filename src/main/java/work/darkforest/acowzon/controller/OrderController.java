package work.darkforest.acowzon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.darkforest.acowzon.entity.base.BaseResponse;
import work.darkforest.acowzon.entity.dto.OrderDto;
import work.darkforest.acowzon.service.OrderService;
import work.darkforest.acowzon.utils.constant.ResponseCodeConstant;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation("查询所有的订单")
    @GetMapping("/getAll")
    public Map getAll(){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, orderService.queryAllOrder()).toMap();
    }

    @ApiOperation("根据id查询订单")
    @GetMapping("/getById")
    public Map getById(@RequestParam("id") String id){
        OrderDto order = orderService.queryOrderById(id);
        if (order != null){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, order).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ORDER_NOT_FIND).toMap();
        }
    }

    @ApiOperation("查询一个买家的所有订单")
    @GetMapping("/getBuyer")
    public Map getBuyer(@RequestParam("id") String id){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, orderService.queryOrderByBuyer(id)).toMap();
    }

    @ApiOperation("查询一个卖家的所有订单")
    @GetMapping("/getRetailer")
    public Map getRetailer(@RequestParam("id") String id){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, orderService.queryOrderByRetailer(id)).toMap();
    }

    @ApiOperation("插入一个订单")
    @GetMapping("/add")
    public Map add(@RequestParam("userId") String userId,
                   @RequestParam("goodsId") String goodsId,
                   @RequestParam("count") int count){
        int state = orderService.addOrder(userId, goodsId, count);
        if (state == 1){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else if (state == -1){
            return new BaseResponse(ResponseCodeConstant.ORDER_GOODS_OUT_OF_INVENTORY).toMap();
        } else if (state == -2){
            return new BaseResponse(ResponseCodeConstant.ORDER_GOODS_NOT_FIND).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ORDER_INSERT_FAILED).toMap();
        }
    }

    @ApiOperation("修改订单价格")
    @GetMapping("/updatePrice")
    public Map updatePrice(@RequestParam("id") String id,
                           @RequestParam("price") double price){
        int state = orderService.updateOrderPrice(id, price);
        if (state == 1){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else if (state == -1){
            return new BaseResponse(ResponseCodeConstant.ORDER_CANT_UPDATE_PRICE_AFTER_PAID).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ORDER_UPDATE_PRICE_FAILED).toMap();
        }
    }

    @ApiOperation("修改订单状态")
    @GetMapping("/updateState")
    public Map updateState(@RequestParam("id") String id,
                           @RequestParam("state") String state){
        if (orderService.updateOrderState(id ,state)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ORDER_UPDATE_STATE_FAILED).toMap();
        }
    }

    @ApiOperation("删除订单")
    @GetMapping("/del")
    public Map del(@RequestParam("id") String id){
        if (orderService.delOrderById(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ORDER_DELETE_FAILED).toMap();
        }
    }
}
