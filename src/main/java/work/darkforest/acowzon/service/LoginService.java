package work.darkforest.acowzon.service;

import org.apache.ibatis.annotations.Param;
import work.darkforest.acowzon.entity.po.Login;

import java.util.List;


public interface LoginService {
    // 查询所有的登录信息
    List<Login> queryAll();

    // 根据id查询一个登录用户
    Login queryLoginById(@Param("id") String id);

    // 根据用户名和密码来查询一个登录用户，判断其是否登录成功，成功会返回其id
    String queryIdByInfo(Login login);

    // 注册一个新的用户信息，会判断用户名是否重复
    String register(Login login);

    // 修改用户名和密码,会判断用户名是否重复
    int updateLogin(Login login);

    // 删除一个用户信息
    Boolean delLoginById(@Param("id") String id);
}
