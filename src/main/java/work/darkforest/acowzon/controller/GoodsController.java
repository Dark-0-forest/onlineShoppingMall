package work.darkforest.acowzon.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.darkforest.acowzon.entity.base.BaseResponse;
import work.darkforest.acowzon.entity.dto.GoodsDto;
import work.darkforest.acowzon.entity.po.Goods;
import work.darkforest.acowzon.service.GoodsService;
import work.darkforest.acowzon.utils.constant.ResponseCodeConstant;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation("查询所有的商品")
    @GetMapping("/getAll")
    public Map getAll(){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, goodsService.queryAllGoods()).toMap();
    }

    @ApiOperation("条件查询")
    @GetMapping("/getByMap")
    public Map getByMap(Map map){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, goodsService.queryGoodsByMap(map)).toMap();
    }

    @ApiOperation("根据id查询")
    @GetMapping("/get")
    public Map get(@RequestParam("id") String id){
        GoodsDto goods = goodsService.queryGoodsById(id);
        if (goods != null){
            return new BaseResponse(ResponseCodeConstant.SUCCESS, goods).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_NOT_FIND).toMap();
        }
    }

    @ApiOperation("查询一个卖家所有的商品")
    @GetMapping("/getByRetailerId")
    public Map getByRetailerId(@RequestParam("id") String id){
        return new BaseResponse(ResponseCodeConstant.SUCCESS, goodsService.queryGoodsByRetailerId(id)).toMap();
    }

    @ApiOperation("上架商品")
    @GetMapping("/add")
    public Map add(GoodsDto goods){
        if (goodsService.addGoods(goods)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_INSERT_FAILED).toMap();
        }
    }

    @ApiOperation("增加浏览量")
    @GetMapping("/view")
    public Map view(@RequestParam("id") String id){
        if (goodsService.updateViews(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("增加喜爱数")
    @GetMapping("/star")
    public Map star(@RequestParam("id") String id){
        if (goodsService.updateStars(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("售出数量")
    @GetMapping("/sold")
    public Map sold(@RequestParam("id") String id,
                    @RequestParam("count") int count){
        if (goodsService.updateSoldCount(id, count)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("修改库存")
    @GetMapping("/inventory")
    public Map inventory(@RequestParam("id") String id,
                         @RequestParam("count") int count){
        if (goodsService.updateInventory(id, count)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("修改信息")
    @GetMapping("/update")
    public Map update(Goods goods){
        if (goodsService.updateGoods(goods)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_UPDATE_FAILED).toMap();
        }
    }

    @ApiOperation("下架商品")
    @GetMapping("/del")
    public Map del(@RequestParam("id") String id){
        if (goodsService.delGoods(id)){
            return new BaseResponse(ResponseCodeConstant.SUCCESS).toMap();
        } else {
            return new BaseResponse(ResponseCodeConstant.GOODS_DELETE_FAILED).toMap();
        }
    }
}
