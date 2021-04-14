package work.darkforest.acowzon.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable{
    private String addressId;   // 地址id
    private String userId;  // 拥有此地址的用户id
    private String receiverName; // 收货人的姓名
    private String receiverPhone;// 收货人的电话号码
    private String addressCountry;  // 国家
    private String addressProvince; // 省
    private String addressCity;     // 市
    private String detail;  // 具体地址
    private Date createTime;    // 创建时间
    private Date updateTime;    // 创建时间

    public Address(String userId, String receiverName, String receiverPhone, String addressCountry,
                   String addressProvince, String addressCity, String detail) {
        this.addressId = UUID.randomUUID().toString();
        this.userId = userId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.addressCountry = addressCountry;
        this.addressProvince = addressProvince;
        this.addressCity = addressCity;
        this.detail = detail;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
