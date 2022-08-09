package club.yiwuyu.zcgl.dto.crkmx;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("更新出入库明细输入参数")
public class CrkmxUpdateInputDTO {

    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "出入库编码",required = true)
    private String crkbh;

    @ApiModelProperty("出入库说明")
    private String crksm;

    @ApiModelProperty("物品分类编码")
    private String wpflbm;

    @ApiModelProperty("物品分类名称")
    private String wpflmc;

    @ApiModelProperty("出入库数量")
    private Integer wpsl;
}
