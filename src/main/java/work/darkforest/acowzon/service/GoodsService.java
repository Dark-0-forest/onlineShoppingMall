package work.darkforest.acowzon.service;

import org.apache.ibatis.annotations.Param;
import work.darkforest.acowzon.entity.dto.GoodsDto;
import work.darkforest.acowzon.entity.po.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    // 查询所有的商品
    List<GoodsDto> queryAllGoods();

    // 根据条件来查询
    List<GoodsDto> queryGoodsByMap(Map map);

    // 根据id查询一个商品
    GoodsDto queryGoodsById(String id);

    // 查询一个卖家的所有商品
    List<GoodsDto> queryGoodsByRetailerId(String id);

    // 添加一个商品
    Boolean addGoods(GoodsDto goods);

    // 增加商品的浏览数,views+1,不需要更新修改时间
    Boolean updateViews(String id);

    // 增加商品的喜欢数,不需要更新修改时间
    Boolean updateStars(String id);

    // 增加商品的售出数量,不需要更新修改时间
    Boolean updateSoldCount(String id, int count);

    // 修改商品的库存,负数为减少，正数为增加
    Boolean updateInventory(String id, int count);

    // 修改商品信息
    Boolean updateGoods(Goods goods);

    // 删除一个商品
    Boolean delGoods(String id);
}
