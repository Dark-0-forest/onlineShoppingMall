package work.darkforest.acowzon.entity.base;

import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;

@Data
public class RetCode {
    private Integer code;
    private String message;

    public RetCode(){}

    public RetCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public static RetCode mark(int code, String message) {
        return new RetCode(code, message);
    }

    public static RetCode mark(Integer code) {
        return new RetCode(code, null);
    }
}


