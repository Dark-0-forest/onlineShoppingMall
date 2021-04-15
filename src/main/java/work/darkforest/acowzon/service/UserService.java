package work.darkforest.acowzon.service;

import org.apache.ibatis.annotations.Param;
import work.darkforest.acowzon.entity.po.User;

import java.util.List;

public interface UserService {
    // 查询所有的用户信息
    List<User> queryAllUser();

    // 根据id查询一个用户信息
    User queryUserById(String id);

    // 查询一个用户昵称是否可用，true为可使用
    Boolean queryNicknameCount(String nickname);

    // 初始化一个用户
    Boolean initUser(User user);

    // 插入一个新的用户的信息
    int addUser(User user);

    // 修改一个用户的信息
    int updateUser(User user);

    // 修改一个用户的类型
    Boolean updateUserType(String id, char userType);

    // 修改一个用户的默认地址id
    int updateAddressId(String id, String addressId);

    // 删除一个用户
    Boolean delUser(String id);
}
