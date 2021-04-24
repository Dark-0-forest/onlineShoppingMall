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
@ApiModel(value="GoodsType对象", description="")
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品类型id")
      @TableId(value = "goods_type_id", type = IdType.ASSIGN_UUID)
    private String goodsTypeId;

    @ApiModelProperty(value = "商品类型")
    private String goodsType;

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
