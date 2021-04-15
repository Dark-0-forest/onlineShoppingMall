package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.dto.AddressDto;
import work.darkforest.acowzon.entity.po.Address;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.mapper.AddressMapper;
import work.darkforest.acowzon.mapper.UserMapper;
import work.darkforest.acowzon.service.AddressService;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<AddressDto> queryAll() {
        return AddressDto.toAddressDto(addressMapper.queryAll());
    }

    @Override
    public List<AddressDto> queryAllByUserId(String id) {
        return AddressDto.toAddressDto(addressMapper.queryAllByUserId(id));
    }

    @Override
    public AddressDto queryAddressById(String id) {
        Address address = addressMapper.queryAddressById(id);
        if (address == null){
            return null;
        }
        return new AddressDto(address);
    }

    @Override
    public int addAddress(AddressDto address) {
        User user = userMapper.queryUserById(address.getUserId());
        if (user == null){
            return -1;
        }
        return addressMapper.addAddress(new Address(address));
    }

    @Override
    public int updateAddress(AddressDto address) {
        User user = userMapper.queryUserById(address.getUserId());
        if (user == null){
            return -1;
        }
        return addressMapper.updateAddress(new Address(address));
    }

    @Override
    public Boolean delAddressById(String id) {
        return addressMapper.delAddressById(id) != 0;
    }
}
