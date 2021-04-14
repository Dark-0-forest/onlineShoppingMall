package work.darkforest.acowzon.utils.constant;

import work.darkforest.acowzon.entity.base.RetCode;

public class ResponseCodeConstant {
    // 成功的返回信息
    public static final RetCode SUCCESS = RetCode.mark(200, "OK");

    // login出现问题
    public static final RetCode USER_NAME_DUPLICATE = RetCode.mark(20001, "用户名已存在");
    public static final RetCode CANT_FIND_USER_INFO_BY_ID = RetCode.mark(20002, "根据ID找不到相关的登录信息");

    // user出现问题
    public static final RetCode USER_NICKNAME_DUPLICATE = RetCode.mark(20101, "用户昵称已存在");
    public static final RetCode INSERT_FAILED = RetCode.mark(20102, "用户插入失败");
    public static final RetCode UPDATE_FAILED = RetCode.mark(20103, "用户信息更新失败");
    public static final RetCode USER_TYPE_UNDEFINED = RetCode.mark(20104, "用户类型有误");
    public static final RetCode USER_TYPE_UPDATE_FAILED = RetCode.mark(20105, "用户类型修改失败");
    public static final RetCode USER_ADDRESS_UPDATE_FAILED = RetCode.mark(20106, "用户默认收获地址修改失败");
    public static final RetCode DELETE_FAILED = RetCode.mark(20107, "删除用户失败");
    public static final RetCode USER_NOT_FIND = RetCode.mark(20108, "未查找到相关的用户信息");
    public static final RetCode USER_INIT_FAILED = RetCode.mark(20109, "用户初始化失败");

    // address出现问题
    public static final RetCode ADDRESS_NOT_FIND = RetCode.mark(20201, "未查询到此地址");
    public static final RetCode ADDRESS_INSERT_FAILED = RetCode.mark(20202, "地址插入失败");
    public static final RetCode ADDRESS_UPDATE_FAILED = RetCode.mark(20203, "地址更新失败");
    public static final RetCode ADDRESS_DELETE_FAILED = RetCode.mark(20204, "地址删除失败");

    // goodsType出现问题
    public static final RetCode GOODS_TYPE_NOT_FIND = RetCode.mark(20301, "商品类别未找到");
    public static final RetCode GOODS_TYPE_INSERT_FAILED = RetCode.mark(20302, "商品类别插入错误");
    public static final RetCode GOODS_TYPE_UPDATE_FAILED = RetCode.mark(20303, "商品类别修改错误");
    public static final RetCode GOODS_TYPE_DELETE_FAILED = RetCode.mark(20304, "商品类别删除错误");

    // goods出现问题
    public static final RetCode GOODS_NOT_FIND = RetCode.mark(20401, "未查询到商品信息");
    public static final RetCode GOODS_QUERY_FAILED = RetCode.mark(20402, "商品查询错误");
    public static final RetCode GOODS_INSERT_FAILED = RetCode.mark(20403, "商品添加失败");
    public static final RetCode GOODS_UPDATE_FAILED = RetCode.mark(20401, "商品信息修改失败");
    public static final RetCode GOODS_DELETE_FAILED = RetCode.mark(20401, "商品删除失败");

    // order出现问题
    public static final RetCode ORDER_NOT_FIND = RetCode.mark(20501, "未查找到订单信息");
    public static final RetCode ORDER_INSERT_FAILED = RetCode.mark(20502, "订单插入失败");
    public static final RetCode ORDER_GOODS_OUT_OF_INVENTORY = RetCode.mark(20503, "商品库存不足");
    public static final RetCode ORDER_UPDATE_PRICE_FAILED = RetCode.mark(20504, "订单价格修改失败");
    public static final RetCode ORDER_CANT_UPDATE_PRICE_AFTER_PAID = RetCode.mark(20505, "你不能在订单已支付后修改价格");
    public static final RetCode ORDER_UPDATE_STATE_FAILED = RetCode.mark(20506, "订单修改失败");
    public static final RetCode ORDER_DELETE_FAILED = RetCode.mark(20507, "订单删除失败");
    public static final RetCode ORDER_GOODS_NOT_FIND = RetCode.mark(20508, "订单商品不存在");
}
