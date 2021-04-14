package work.darkforest.acowzon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.darkforest.acowzon.entity.po.Comment;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    // 查询所有的评论
    List<Comment> queryAll();

    // 查询对应商品id的所有评论
    List<Comment> queryAllByGoodsId(@Param("id") String id);

    // 查询对应商品id的评论数量
    int queryCommentCountByGoodsId(@Param("id") String id);

    // 根据id查询评论信息
    Comment queryCommentById(@Param("id") String id);

    // 添加一条评论信息
    int addComment(Comment comment);

    // 删除一条评论信息
    int delCommentById(@Param("id") String id);
}
