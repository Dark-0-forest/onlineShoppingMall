package work.darkforest.acowzon.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.darkforest.acowzon.entity.base.BaseResponse;
import work.darkforest.acowzon.entity.dto.AddressDto;
import work.darkforest.acowzon.service.AddressService;
import work.darkforest.acowzon.utils.constant.ResponseCodeConstant;

import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @ApiOperation("查询所有地址")
    @GetMapping("/getAll")
    public Map getAll(){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, addressService.queryAll()).toMap();
    }

    @ApiOperation("查询指定用户的所有地址")
    @GetMapping("/getByUser")
    public Map getByUser(@RequestParam("id") String id){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, addressService.queryAllByUserId(id)).toMap();
    }

    @ApiOperation("根据id查询一个地址")
    @GetMapping("/get")
    public Map get(@RequestParam("id") String id){
        AddressDto address = addressService.queryAddressById(id);
        if (address != null) {
            return new BaseResponse(ResponseCodeConstant.SUCCESS, address).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ADDRESS_NOT_FIND).toMap();
        }
    }

    @ApiOperation("插入地址")
    @GetMapping("/insert")
    public Map insert(AddressDto address){
        if (addressService.addAddress(address)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ADDRESS_INSERT_FAILED).toMap();
        }
    }

    @ApiOperation("修改地址")
    @GetMapping("/update")
    public Map update(AddressDto address){
        if (addressService.updateAddress(address)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ADDRESS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("删除地址")
    @GetMapping("/del")
    public Map del(@RequestParam("id") String id){
        if (addressService.delAddressById(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.ADDRESS_DELETE_FAILED).toMap();
        }
    }
}
