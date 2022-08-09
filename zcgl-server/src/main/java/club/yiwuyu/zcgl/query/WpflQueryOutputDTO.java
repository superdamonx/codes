package club.yiwuyu.zcgl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("物品查询分类输出参数")
public class WpflQueryOutputDTO {

    @NotBlank
    @ApiModelProperty(value = "分类编码",required = true)
    private String flbm;

    @ApiModelProperty("分类名称")
    private String flmc;

    @ApiModelProperty("图片路径")
    private String tplj;

    @ApiModelProperty("计量单位")
    private String jldw;

    @ApiModelProperty("分类序号")
    private String flxh;

    @ApiModelProperty("分类说明")
    private String flsm;

    @ApiModelProperty("备注")
    private String bz;

}
