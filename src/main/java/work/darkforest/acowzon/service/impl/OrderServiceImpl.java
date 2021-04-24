package work.darkforest.acowzon.service.impl;

import work.darkforest.acowzon.entity.po.Order;
import work.darkforest.acowzon.mapper.OrderMapper;
import work.darkforest.acowzon.service.OrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
