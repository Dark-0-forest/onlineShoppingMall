package work.darkforest.acowzon.utils.constant;

import work.darkforest.acowzon.entity.base.RetCode;

public class ResponseCodeConstant {
    // 成功的返回信息
    public static final RetCode SUCCESS = RetCode.mark(200, "OK");

    // login出现问题
    public static final RetCode USER_NAME_DUPLICATE = RetCode.mark(20001, "用户名已存在");
    public static final RetCode CANT_FIND_USER_INFO_BY_ID = RetCode.mark(20002, "根据ID找不到相关的用户信息");

    // user出现问题
    public static final RetCode USER_NICKNAME_DUPLICATE = RetCode.mark(20101, "用户昵称已存在");
    public static final RetCode INSERT_FAILED = RetCode.mark(20102, "插入失败");
    public static final RetCode UPDATE_FAILED = RetCode.mark(20103, "更新失败");
    public static final RetCode USER_TYPE_UNDEFINED = RetCode.mark(20104, "用户类型有误");
    public static final RetCode USER_TYPE_UPDATE_FAILED = RetCode.mark(20105, "用户类型修改失败");
    public static final RetCode ADDRESS_UPDATE_FAILED = RetCode.mark(20106, "默认收获地址修改失败");
    public static final RetCode DELETE_FAILED = RetCode.mark(20107, "删除用户失败");
    public static final RetCode USER_NOT_FIND = RetCode.mark(20108, "未查找到相关的用户信息");
    public static final RetCode USER_INIT_FAILED = RetCode.mark(20109, "用户初始化失败");
}
