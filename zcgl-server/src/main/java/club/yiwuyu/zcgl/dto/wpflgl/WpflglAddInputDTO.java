package club.yiwuyu.zcgl.dto.wpflgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("物品分类添加输入参数")
public class WpflglAddInputDTO {

    @NotBlank(message = "分类名称不能为空")
    @ApiModelProperty(value = "分类名称",required = true)
    private String flmc;

    @ApiModelProperty("分类说明")
    private String flsm;

    @ApiModelProperty("分类序号")
    private Integer flxh;

    @NotBlank(message = "计量单位不能为空")
    @ApiModelProperty(value = "计量单位",required = true)
    private String jldw;

    @ApiModelProperty("图片路径")
    private String tplj;
}