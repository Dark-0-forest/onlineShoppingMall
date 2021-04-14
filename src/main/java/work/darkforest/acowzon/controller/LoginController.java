package work.darkforest.acowzon.controller;

import com.alibaba.druid.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.darkforest.acowzon.entity.base.BaseResponse;
import work.darkforest.acowzon.entity.dto.LoginDto;
import work.darkforest.acowzon.entity.po.Login;
import work.darkforest.acowzon.service.LoginService;
import work.darkforest.acowzon.utils.constant.ResponseCodeConstant;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public Map register(LoginDto loginDto) {
        Login login = new Login(loginDto);
        String userId = loginService.register(login);
        if(!StringUtils.isEmpty(userId)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, userId).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.USER_NAME_DUPLICATE).toMap();
        }
    }

    @ApiOperation("登录")
    @PostMapping("/signIn")
    private Map signIn(LoginDto loginDto){
        String id = loginService.queryIdByInfo(new Login(loginDto));
        if (!StringUtils.isEmpty(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, id).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.CANT_FIND_USER_INFO_BY_ID).toMap();
        }
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/getAll")
    private Map getAll(){
        List<Login> logins = loginService.queryAll();
        return new BaseResponse(ResponseCodeConstant.SUCCESS, logins).toMap();
    }

    @ApiOperation("根据ID获得用户信息")
    @GetMapping("/get")
    private Map getInfo(@RequestParam("id") String id){
        Login login = loginService.queryLoginById(id);
        if (login != null){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, login).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.CANT_FIND_USER_INFO_BY_ID).toMap();
        }
    }

    @ApiOperation("修改用户信息")
    @GetMapping("/update")
    public Map update(Login login){
        int state = loginService.updateLogin(login);
        if(state == 1){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else if(state == 0){
            return new BaseResponse(ResponseCodeConstant.USER_NAME_DUPLICATE).toMap();
        } else{
            return new BaseResponse(ResponseCodeConstant.CANT_FIND_USER_INFO_BY_ID).toMap();
        }
    }

    @ApiOperation("删除用户")
    @GetMapping("/del")
    public Map del(@RequestParam("id") String id){
        if (loginService.delLoginById(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new  BaseResponse(ResponseCodeConstant.CANT_FIND_USER_INFO_BY_ID).toMap();
        }
    }
}
