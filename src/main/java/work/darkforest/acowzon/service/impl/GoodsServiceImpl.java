package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.dto.GoodsDto;
import work.darkforest.acowzon.entity.po.Goods;
import work.darkforest.acowzon.entity.po.GoodsType;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.mapper.GoodsMapper;
import work.darkforest.acowzon.mapper.GoodsTypeMapper;
import work.darkforest.acowzon.mapper.UserMapper;
import work.darkforest.acowzon.service.GoodsService;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsTypeMapper goodsTypeMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<GoodsDto> queryAllGoods() {
        return GoodsDto.toGoodsDto(goodsMapper.queryAllGoods());
    }

    @Override
    public List<GoodsDto> queryGoodsByMap(Map map) {
        return GoodsDto.toGoodsDto(goodsMapper.queryGoodsByMap(map));
    }

    @Override
    public GoodsDto queryGoodsById(String id) {
        Goods goods = goodsMapper.queryGoodsById(id);
        if (goods == null){
            return null;
        } else {
            return new GoodsDto(goods);
        }
    }

    @Override
    public List<GoodsDto> queryGoodsByRetailerId(String id) {
        return GoodsDto.toGoodsDto(goodsMapper.queryGoodsByRetailerId(id));
    }

    @Override
    public int addGoods(GoodsDto goods) {
        GoodsType type = goodsTypeMapper.queryById(goods.getGoodsTypeId());
        if (type == null){  // 未搜到类别
            return -1;
        }
        User user = userMapper.queryUserById(goods.getRetailerId());
        if (user == null){  // 未搜索到用户
            return -2;
        } else if (user.getUserType() != '1'){  // 用户类型不为卖家
            return -3;
        }
        return goodsMapper.addGoods(new Goods(goods));
    }

    @Override
    public Boolean updateViews(String id) {
        return goodsMapper.updateViews(id) != 0;
    }

    @Override
    public Boolean updateStars(String id) {
        return goodsMapper.updateStars(id) != 0;
    }

    @Override
    public Boolean updateSoldCount(String id, int count) {
        return goodsMapper.updateSoldCount(id, count) != 0;
    }

    @Override
    public Boolean updateInventory(String id, int count) {
        Goods goods = goodsMapper.queryGoodsById(id);
        if (goods.getGoodsInventory() + count < 0){
            return false;
        }
        return goodsMapper.updateInventory(id, count) != 0;
    }

    @Override
    public int updateGoods(Goods goods) {
        GoodsType type = goodsTypeMapper.queryById(goods.getGoodsTypeId());
        if (type == null){  // 未搜到类别
            return -1;
        }
        User user = userMapper.queryUserById(goods.getRetailerId());
        if (user == null){  // 未搜索到用户
            return -2;
        } else if (user.getUserType() != '1'){  // 用户类型不为卖家
            return -3;
        }
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public Boolean delGoods(String id) {
        return goodsMapper.delGoods(id) != 0;
    }
}
