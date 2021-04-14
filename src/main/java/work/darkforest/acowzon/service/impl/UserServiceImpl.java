package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.mapper.UserMapper;
import work.darkforest.acowzon.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserById(String id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public Boolean queryNicknameCount(String nickname) {
        return userMapper.queryNicknameCount(nickname) == 0;
    }

    @Override
    public Boolean initUser(User user) {
        return userMapper.initUser(user) != 0;
    }

    @Override
    public int addUser(User user) {
        if (userMapper.queryNicknameCount(user.getUserNickname()) == 0){    // 用户名未重复
            if(userMapper.addUser(user) != 0){
                return 1;   // 插入成功返回1
            } else {
                return 0;   // 插入失败返回0
            }
        } else {
            return -1;   // 用户名重名返回-1
        }
    }

    @Override
    public int updateUser(User user) {
        if (userMapper.queryNicknameCount(user.getUserNickname()) == 0){    // 用户名未重复
            if(userMapper.updateUser(user) != 0){
                return 1;   // 插入成功返回1
            } else {
                return 0;   // 更新失败返回0
            }
        } else {
            String name = userMapper.queryUserById(user.getUserId()).getUserNickname();
            if (name.equals(user.getUserNickname())){
                if(userMapper.updateUser(user) != 0){
                    return 1;   // 插入成功返回1
                } else {
                    return 0;   // 更新失败返回0
                }
            } else {
                return -1;   // 用户名重名返回-1jdbc:mysql://localhost:3306/acowzon?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8
            }
        }
    }

    @Override
    public Boolean updateUserType(String id, char userType) {
        return userMapper.updateUserType(id, userType) != 0;
    }

    @Override
    public Boolean updateAddressId(String id, String addressId) {
        return userMapper.updateAddressId(id, addressId) != 0;
    }

    @Override
    public Boolean delUser(String id) {
        return userMapper.delUser(id) != 0;
    }
}
