package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.po.Login;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.mapper.LoginMapper;
import work.darkforest.acowzon.mapper.UserMapper;
import work.darkforest.acowzon.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;
    @Autowired
    UserMapper userMapper;


    @Override
    public List<Login> queryAll() {
        return loginMapper.queryAll();
    }

    @Override
    public Login queryLoginById(String id) {
        return loginMapper.queryLoginById(id);
    }

    @Override
    public String queryIdByInfo(Login login) {
        return loginMapper.queryIdByInfo(login);
    }

    @Override
    public String register(Login login) {
        if (loginMapper.queryUsernameCount(login.getUserName()) != 0){    // 如果用户名已经使用，返回错误
            return "";
        } else {
            // 错误返回false
            if (loginMapper.addLogin(login) != 0){
                // 登录表注册成功后，会在用户表初始化一个对应的用户
                userMapper.initUser(new User(login.getUserId(), login.getUserName()));
                return login.getUserId();
            } else {
                return "";
            }
        }
    }

    @Override
    public int updateLogin(Login login) {
        if (loginMapper.queryUsernameCount(login.getUserName()) != 0){    // 如果用户名已经使用，返回0
            return 0;
        } else {
            if (loginMapper.updateLogin(login) != 0){
                return 1;
            }else {
                return -1; // 错误返回-1
            }
        }
    }

    @Override
    public Boolean delLoginById(String id) {
        // 错误返回false
        return loginMapper.delLoginById(id) != 0;
    }
}
