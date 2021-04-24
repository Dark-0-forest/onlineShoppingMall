package work.darkforest.acowzon.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Darkforest
 * @since 2021-04-24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Goods对象", description="")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
      @TableId(value = "goods_id", type = IdType.ASSIGN_UUID)
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品类型id")
    private String goodsTypeId;

    @ApiModelProperty(value = "商品价格")
    private Double goodsPrice;

    @ApiModelProperty(value = "商品图片路径")
    private String goodsImage;

    @ApiModelProperty(value = "商品简单描述")
    private String goodsSimpleDes;

    @ApiModelProperty(value = "商品详情")
    private String goodsDescription;

    @ApiModelProperty(value = "商品库存")
    private Integer goodsInventory;

    @ApiModelProperty(value = "已售数量")
    private Integer soldCount;

    @ApiModelProperty(value = "商家id")
    private String retailerId;

    @ApiModelProperty(value = "喜爱数")
    private Integer goodsStarsCount;

    @ApiModelProperty(value = "浏览量")
    private Integer views;

    @ApiModelProperty(value = "version乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
