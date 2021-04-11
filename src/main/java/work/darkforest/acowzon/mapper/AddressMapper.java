package work.darkforest.acowzon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.darkforest.acowzon.entity.pojo.Address;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    // 查询一个用户的所有地址
    List<Address> queryAllByUserId(@Param("id") String id);

    // 根据Id查询一个地址
    Address queryAddressById(@Param("id") String id);

    // 插入一个新的地址
    int addAddress(Address address);

    // 修改一个地址的信息
    int updateAddress(Address address);

    // 根据id删除一个地址
    int delAddressById(@Param("id") String id);
}
