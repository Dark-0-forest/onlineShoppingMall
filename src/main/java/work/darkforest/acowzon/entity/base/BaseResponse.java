package work.darkforest.acowzon.entity.base;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse {
    private int code;
    private String message;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(int code) {
        this.code = code;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(RetCode retCode) {
        this.code = retCode.getCode();
        this.message = retCode.getMessage();
    }

    public BaseResponse(RetCode retCode ,Object data) {
        this.code = retCode.getCode();
        this.message = retCode.getMessage();
        this.data = data;
    }

    public BaseResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Map toMap(){
        Map<String, Object> map = new HashMap();
        map.put("code", this.code);
        map.put("message", this.message);
        map.put("data", this.data);
        return map;
    }
}
