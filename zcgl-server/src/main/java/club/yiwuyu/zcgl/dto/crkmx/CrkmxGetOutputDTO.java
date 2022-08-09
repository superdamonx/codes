package club.yiwuyu.zcgl.dto.crkmx;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查看出入库详情输出参数")
public class CrkmxGetOutputDTO {


    @ApiModelProperty("出入库编号")
    private String crkbh;

    @ApiModelProperty("出入库类型")
    private String crklx;

    @ApiModelProperty("出入库时间")
    private String crksj;

    @ApiModelProperty("出入库说明")
    private String crksm;

    @ApiModelProperty("操作人编码")
    private String czrbm;

    @ApiModelProperty("操作人名称")
    private String czrmc;

    @ApiModelProperty("物品分类编码")
    private String wpflbm;

    @ApiModelProperty("物品分类名称")
    private String wpflmc;

    @ApiModelProperty("物品数量")
    private Double wpsl;
}
