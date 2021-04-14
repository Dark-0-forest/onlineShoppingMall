package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.dto.AddressDto;
import work.darkforest.acowzon.entity.po.Address;
import work.darkforest.acowzon.mapper.AddressMapper;
import work.darkforest.acowzon.service.AddressService;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

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
        return new AddressDto(addressMapper.queryAddressById(id));
    }

    @Override
    public Boolean addAddress(AddressDto addressDto) {
        return addressMapper.addAddress(new Address(addressDto)) != 0;
    }

    @Override
    public Boolean updateAddress(AddressDto address) {
        return addressMapper.updateAddress(new Address(address)) != 0;
    }

    @Override
    public Boolean delAddressById(String id) {
        return addressMapper.delAddressById(id) != 0;
    }
}
