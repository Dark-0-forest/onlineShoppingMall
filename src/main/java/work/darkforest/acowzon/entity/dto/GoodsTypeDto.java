package work.darkforest.acowzon.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.po.GoodsType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsTypeDto {
    private String goodsType;   // 类别

    public GoodsTypeDto(GoodsType goodsType){
        this.goodsType = goodsType.getGoodsType();
    }
}
