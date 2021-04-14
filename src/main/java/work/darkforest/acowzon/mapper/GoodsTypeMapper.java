package work.darkforest.acowzon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.darkforest.acowzon.entity.po.GoodsType;

import java.util.List;

@Mapper
@Repository
public interface GoodsTypeMapper {
    // 查询所有的商品类型
    List<GoodsType> queryAllType();

    // 根据id查询商品类型
    GoodsType queryById(@Param("id") String id);

    // 插入一个新的商品类型
    int addType(GoodsType type);

    // 删除一个商品类型
    int delType(@Param("id") String id);

    // 修改一个商品类别
    int updateType(@Param("id") String id, @Param("type") String type);
}
