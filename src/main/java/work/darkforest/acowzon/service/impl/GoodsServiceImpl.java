package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.dto.GoodsDto;
import work.darkforest.acowzon.entity.po.Goods;
import work.darkforest.acowzon.mapper.GoodsMapper;
import work.darkforest.acowzon.service.GoodsService;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

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
    public Boolean addGoods(GoodsDto goods) {
        return goodsMapper.addGoods(new Goods(goods)) != 0;
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
        return goodsMapper.updateInventory(id, count) != 0;
    }

    @Override
    public Boolean updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods) != 0;
    }

    @Override
    public Boolean delGoods(String id) {
        return goodsMapper.delGoods(id) != 0;
    }
}
