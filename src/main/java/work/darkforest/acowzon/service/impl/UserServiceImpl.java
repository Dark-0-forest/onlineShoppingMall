package work.darkforest.acowzon.service.impl;

import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.mapper.UserMapper;
import work.darkforest.acowzon.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Darkforest
 * @since 2021-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
