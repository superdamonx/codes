package club.yiwuyu.zcgl.dto.crkmx;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("添加出入库信息输入参数")
public class CrkmxAddInputDTO {

    @NotBlank
    @ApiModelProperty(value = "出入库类型",required = true)
    private String crklx;

    @ApiModelProperty("出入库说明")
    private String crksm;

    @NotBlank
    @ApiModelProperty(value = "物品分类编码",required = true)
    private String wpflbm;

    @ApiModelProperty("物品分类名称")
    private String wpflmc;

    @NotBlank
    @ApiModelProperty(value = "=物品数量",required = true)
    private Integer wpsl;
}
