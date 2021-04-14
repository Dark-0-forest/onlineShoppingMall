package work.darkforest.acowzon.service;

import org.apache.ibatis.annotations.Param;
import work.darkforest.acowzon.entity.dto.GoodsTypeDto;
import work.darkforest.acowzon.entity.po.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    // 查询所有的商品类型
    List<GoodsType> queryAllType();

    // 根据id查询商品类型
    GoodsType queryById(String id);

    // 插入一个新的商品类型
    Boolean addType(GoodsTypeDto type);

    // 删除一个商品类型
    Boolean delType(String id);

    // 修改一个商品类别
    Boolean updateType(String id, String type);
}
