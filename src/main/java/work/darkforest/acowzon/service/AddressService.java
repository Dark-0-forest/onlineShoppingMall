package work.darkforest.acowzon.service;

import org.apache.ibatis.annotations.Param;
import work.darkforest.acowzon.entity.dto.AddressDto;
import work.darkforest.acowzon.entity.po.Address;

import java.util.List;

public interface AddressService {
    // 查询所有的地址
    List<AddressDto> queryAll();

    // 查询一个用户的所有地址
    List<AddressDto> queryAllByUserId(String id);

    // 根据Id查询一个地址
    AddressDto queryAddressById(String id);

    // 插入一个新的地址
    Boolean addAddress(AddressDto addressDto);

    // 修改一个地址的信息
    Boolean updateAddress(AddressDto address);

    // 根据id删除一个地址
    Boolean delAddressById(String id);
}
