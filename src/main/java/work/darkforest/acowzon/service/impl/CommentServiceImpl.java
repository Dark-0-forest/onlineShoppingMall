package work.darkforest.acowzon.service.impl;

import work.darkforest.acowzon.entity.po.Comment;
import work.darkforest.acowzon.mapper.CommentMapper;
import work.darkforest.acowzon.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
