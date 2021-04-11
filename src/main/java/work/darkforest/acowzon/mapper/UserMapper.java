package work.darkforest.acowzon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.darkforest.acowzon.entity.pojo.User;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    // 查询所有的用户信息
    List<User> queryAllUser();

    // 根据d查询一个用户信息
    User queryUserById(@Param("id") String id);

    // 插入一个新的用户的信息
    int addUser(User user);

    // 修改一个用户的信息
    int updateUser(User user);

    // 修改一个用户的类型
    int updateUserType(@Param("id") String id, @Param("userType") char userType);
}
