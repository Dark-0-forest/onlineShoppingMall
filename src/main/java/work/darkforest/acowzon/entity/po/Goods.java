package work.darkforest.acowzon.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    private String goodsId; // 商品id
    private String goodsName; // 商品名称
    private String goodsTypeId; // 商品类型
    private double goodsPrice; // 商品价格
    private String goodsImage; // 商品图片的存储地址
    private String goodsSimpleDes; // 商品的简单描述
    private String goodsDescription; // 商品的描述
    private int goodsInventory; // 商品库存
    private int soldCount; // 商品售出个数
    private String retailerId; // 商品上架商家的id
    private int goodsStarsCount; // 喜欢此商品的人数
    private int views; // 商品的浏览数
    private Date createTime; // 商品创建时间
    private Date updateTime; // 商品修改时间

    // 用于插入的构造函数
    public Goods(String goodsName, String goodsTypeId, double goodsPrice, String goodsImage, String goodsSimpleDes,
                 String goodsDescription, int goodsInventory, String retailerId) {
        this.goodsId = UUID.randomUUID().toString();
        this.goodsName = goodsName;
        this.goodsTypeId = goodsTypeId;
        this.goodsPrice = goodsPrice;
        this.goodsImage = goodsImage;
        this.goodsSimpleDes = goodsSimpleDes;
        this.goodsDescription = goodsDescription;
        this.goodsInventory = goodsInventory;
        this.soldCount = 0;
        this.retailerId = retailerId;
        this.goodsStarsCount = 0;
        this.views = 0;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}