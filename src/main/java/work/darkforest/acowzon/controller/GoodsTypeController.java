package work.darkforest.acowzon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.darkforest.acowzon.entity.base.BaseResponse;
import work.darkforest.acowzon.entity.dto.GoodsTypeDto;
import work.darkforest.acowzon.entity.po.GoodsType;
import work.darkforest.acowzon.service.GoodsTypeService;
import work.darkforest.acowzon.utils.constant.ResponseCodeConstant;

import java.util.Map;

@RestController
@RequestMapping("/type")
public class GoodsTypeController {
    @Autowired
    GoodsTypeService goodsTypeService;

    @ApiOperation("查询所有的商品类别")
    @GetMapping("/getAll")
    public Map getAll(){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, goodsTypeService.queryAllType()).toMap();
    }

    @ApiOperation("根据id查询商品类型")
    @GetMapping("/get")
    public Map get(@RequestParam("id") String id){
        GoodsType type = goodsTypeService.queryById(id);
        if (type != null){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, type).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_TYPE_NOT_FIND).toMap();
        }
    }

    @ApiOperation("插入一个商品类别")
    @GetMapping("/add")
    public Map add(GoodsTypeDto type){
        if (goodsTypeService.addType(type)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_TYPE_INSERT_FAILED).toMap();
        }
    }

    @ApiOperation("删除一个类别")
    @GetMapping("/del")
    public Map del(@RequestParam("id") String id){
        if (goodsTypeService.delType(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_TYPE_DELETE_FAILED).toMap();
        }
    }

    @ApiOperation("修改一个类别")
    @GetMapping("/update")
    public Map update(@RequestParam("id") String id,
                      @RequestParam("type") String type){
        if (goodsTypeService.updateType(id, type)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_TYPE_UPDATE_FAILED).toMap();
        }

    }
}
