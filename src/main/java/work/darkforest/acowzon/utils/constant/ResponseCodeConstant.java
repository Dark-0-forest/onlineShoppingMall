package work.darkforest.acowzon.utils.constant;

import work.darkforest.acowzon.entity.base.RetCode;

public class ResponseCodeConstant {
    // 成功的返回信息
    public static final RetCode SUCCESS = RetCode.mark(200, "OK");


    public static final RetCode USER_NAME_DUPLICATE = RetCode.mark(20001, "用户名已存在");
    public static final RetCode CANT_FIND_USER_INFO_BY_ID = RetCode.mark(20002, "根据ID找不到相关的用户信息");
}
