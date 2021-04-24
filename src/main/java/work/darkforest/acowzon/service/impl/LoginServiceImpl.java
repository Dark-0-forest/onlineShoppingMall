package work.darkforest.acowzon.service.impl;

import work.darkforest.acowzon.entity.po.Login;
import work.darkforest.acowzon.mapper.LoginMapper;
import work.darkforest.acowzon.service.LoginService;
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
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

}
