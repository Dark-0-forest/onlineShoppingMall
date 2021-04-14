package work.darkforest.acowzon.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.darkforest.acowzon.entity.base.BaseResponse;
import work.darkforest.acowzon.entity.dto.UserDto;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.service.UserService;
import work.darkforest.acowzon.utils.constant.ResponseCodeConstant;
import work.darkforest.acowzon.utils.constant.UserTypeConstant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("获取所有用户信息")
    @GetMapping("/getAll")
    public Map getAll(){
        List<User> users = userService.queryAllUser();
        return new BaseResponse(ResponseCodeConstant.SUCCESS, UserDto.toUserDto(users)).toMap();
    }

    @ApiOperation("根据id获得用户信息")
    @GetMapping("/get")
    public Map getById(@RequestParam("id") String id){
        User user = userService.queryUserById(id);
        if (user != null){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, new UserDto(user)).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_NOT_FIND).toMap();
        }
    }

    @ApiOperation("查看用户名是否重复")
    @GetMapping("/nickname")
    public Map nicknameDup(@RequestParam("nickname") String nickname){
        if(userService.queryNicknameCount(nickname)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_NICKNAME_DUPLICATE).toMap();
        }
    }

    @ApiOperation("初始化用户")
    @GetMapping("/init")
    public Map init(@RequestParam("userId") String userId,
                    @RequestParam("username") String username){
        if(userService.initUser(new User(userId, username))){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_INIT_FAILED).toMap();
        }
    }

    @ApiOperation("插入用户")
    @GetMapping("/add")
    public Map add(User user){
        int state = userService.addUser(user);
        if (state == 1){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else if (state == 0){
            return new BaseResponse(ResponseCodeConstant.INSERT_FAILED).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_NICKNAME_DUPLICATE).toMap();
        }

    }

    @ApiOperation("修改用户信息")
    @GetMapping("/updateInfo")
    public Map updateInfo(UserDto userDto){
        User user = new User(userDto);
        int state = userService.updateUser(user);
        // 传入生日时要用 1970/01/01
        if (state == 1){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else if (state == 0){
            return new BaseResponse(ResponseCodeConstant.UPDATE_FAILED).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_NICKNAME_DUPLICATE).toMap();
        }
    }

    @ApiOperation("修改用户类型")
    @GetMapping("/updateType")
    public Map updateType(@RequestParam("userId") String userId,
                          @RequestParam("userType") String userType){
        char type;
        if (userType.equals("买家")){
            type = UserTypeConstant.BUYER;
        } else if (userType.equals("卖家")){
            type = UserTypeConstant.RETAILER;
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_TYPE_UNDEFINED).toMap();
        }
        if (userService.updateUserType(userId, type)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_TYPE_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("修改用户的默认地址")
    @GetMapping("/address")
    public Map updateAddress(@RequestParam("userId") String userId,
                             @RequestParam("addressId") String addressId){
        if (userService.updateAddressId(userId, addressId)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_ADDRESS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("删除用户")
    @GetMapping("/del")
    public Map del(@RequestParam("id") String id){
        if (userService.delUser(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.DELETE_FAILED).toMap();
        }
    }
}
