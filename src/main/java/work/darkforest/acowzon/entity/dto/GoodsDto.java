package work.darkforest.acowzon.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.po.Goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
    private String goodsId; // 商品id
    private String goodsName; // 商品名称
    private String goodsTypeId; // 商品类型id
    private double goodsPrice; // 商品价格
    private String goodsImage; // 商品图片的存储地址
    private String goodsSimpleDes; // 商品的简单描述
    private String goodsDescription; // 商品的描述
    private int goodsInventory; // 商品库存
    private int soldCount; // 商品售出个数
    private String retailerId; // 商品上架商家的id
    private int goodsStarsCount; // 喜欢此商品的人数
    private int views; // 商品的浏览数

    public GoodsDto(Goods goods) {
        this.goodsId = goods.getGoodsId();
        this.goodsName = goods.getGoodsName();
        this.goodsTypeId = goods.getGoodsTypeId();
        this.goodsPrice = goods.getGoodsPrice();
        this.goodsImage = goods.getGoodsImage();
        this.goodsSimpleDes = goods.getGoodsSimpleDes();
        this.goodsDescription = goods.getGoodsDescription();
        this.goodsInventory = goods.getGoodsInventory();
        this.soldCount = goods.getSoldCount();
        this.retailerId = goods.getRetailerId();
        this.goodsStarsCount = goods.getGoodsStarsCount();
        this.views = goods.getViews();
    }

    public static List<GoodsDto> toGoodsDto(List<Goods> list){
        ArrayList<GoodsDto> goodsDto = new ArrayList<>();
        for (Goods goods : list) {
            goodsDto.add(new GoodsDto(goods));
        }
        return goodsDto;
    }
}
