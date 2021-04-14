package work.darkforest.acowzon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.darkforest.acowzon.entity.dto.GoodsTypeDto;
import work.darkforest.acowzon.entity.po.GoodsType;
import work.darkforest.acowzon.mapper.GoodsTypeMapper;
import work.darkforest.acowzon.service.GoodsTypeService;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> queryAllType() {
        return goodsTypeMapper.queryAllType();
    }

    @Override
    public GoodsType queryById(String id) {
        return goodsTypeMapper.queryById(id);
    }

    @Override
    public Boolean addType(GoodsTypeDto type) {
        return goodsTypeMapper.addType(new GoodsType(type)) != 0;
    }

    @Override
    public Boolean delType(String id) {
        return goodsTypeMapper.delType(id) != 0;
    }

    @Override
    public Boolean updateType(String id, String type) {
        return goodsTypeMapper.updateType(id, type) != 0;
    }
}
