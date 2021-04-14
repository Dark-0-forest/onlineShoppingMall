package work.darkforest.acowzon.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.po.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class AddressDto {
    private String addressId;   // id
    private String userId;      // 拥有此地址的用户id
    private String receiverName; // 收货人的姓名
    private String receiverPhone;// 收货人的电话号码
    private String addressCountry;  // 国家
    private String addressProvince; // 省
    private String addressCity;     // 市
    private String detail;  // 具体地址

    public AddressDto(String addressId, String userId, String receiverName, String receiverPhone, String addressCountry,
                      String addressProvince, String addressCity, String detail) {
        this.addressId = addressId;
        this.userId = userId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.addressCountry = addressCountry;
        this.addressProvince = addressProvince;
        this.addressCity = addressCity;
        this.detail = detail;
    }

    public AddressDto(Address address){
        this.addressId = address.getAddressId();
        this.userId = address.getUserId();
        this.receiverName = address.getReceiverName();
        this.receiverPhone = address.getReceiverPhone();
        this.addressCountry = address.getAddressCountry();
        this.addressProvince = address.getAddressProvince();
        this.addressCity = address.getAddressCity();
        this.detail = address.getDetail();
    }

    public static List<AddressDto> toAddressDto(List<Address> addresses){
        List<AddressDto> addressDtos = new ArrayList<AddressDto>();
        for (Address address : addresses) {
            addressDtos.add(new AddressDto(address));
        }
        return addressDtos;
    }
}
