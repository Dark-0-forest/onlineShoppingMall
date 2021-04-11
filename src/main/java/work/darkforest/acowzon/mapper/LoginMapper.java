package work.darkforest.acowzon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.darkforest.acowzon.entity.pojo.Login;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {
    // 查询所有的登录信息
    List<Login> queryAll();

    // 根据id查询一个登录用户
    Login queryLoginById(@Param("id") String id);

    // 根据用户名和密码来查询一个登录用户，判断其是否登录成功，并返回其id
    String queryIdByInfo(Login login);

    // 查询一个用户名在表中的出现次数，判断用户名是否会重复
    int queryUsernameCount(@Param("username") String username);

    // 新增一个新的用户信息
    int addLogin(Login login);

    // 修改用户名和密码
    int updateLogin(Login login);

    // 删除一个用户信息
    int delLoginById(@Param("id") String id);
}
