package club.yiwuyu.zcgl.dto.wpflgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("修改分类输出参数")
public class WpflglUpdateInputDTO {

    @NotBlank
    @ApiModelProperty(value = "分类编码",required = true)
    private String flbm;

    @ApiModelProperty("分类名称")
    private String flmc;

    @ApiModelProperty("分类说明")
    private String flsm;

    @ApiModelProperty("分类序号")
    private Integer flxh;

    @ApiModelProperty("计量单位")
    private String jldw;

    @ApiModelProperty("图片路径")
    private String tplj;
}
