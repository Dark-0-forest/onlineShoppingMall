package work.darkforest.acowzon.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.dto.GoodsTypeDto;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsType implements Serializable {
    private String goodsTypeId; // 类别id
    private String goodsType;   // 类别

    public GoodsType(String goodsType) {
        this.goodsTypeId = UUID.randomUUID().toString();
        this.goodsType = goodsType;
    }

    public GoodsType(GoodsTypeDto goodsType) {
        this.goodsTypeId = UUID.randomUUID().toString();
        this.goodsType = goodsType.getGoodsType();
    }
}