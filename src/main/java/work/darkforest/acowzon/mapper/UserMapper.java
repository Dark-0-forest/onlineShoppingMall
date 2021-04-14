package work.darkforest.acowzon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.darkforest.acowzon.entity.po.User;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    // 查询所有的用户信息
    List<User> queryAllUser();

    // 根据id查询一个用户信息
    User queryUserById(@Param("id") String id);

    // 查询一个用户昵称出现的次数
    int queryNicknameCount(@Param("nickname") String nickname);

    // 初始化一个用户
    int initUser(User user);

    // 插入一个新的用户的信息
    int addUser(User user);

    // 修改一个用户的信息
    int updateUser(User user);

    // 修改一个用户的类型
    int updateUserType(@Param("id") String id, @Param("userType") char userType);

    // 修改一个用户的默认地址id
    int updateAddressId(@Param("id") String id, @Param("addressId") String addressId);

    // 删除一个用户
    int delUser(@Param("id") String id);
}
