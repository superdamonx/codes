package club.yiwuyu.zcgl.query;


import club.yiwuyu.zcgl.util.page.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("查看出入库管理列表输入参数")
public class CrkmxQueryInputDTO {

    @ApiModelProperty("出入库类型")
    private String crklx;

    @ApiModelProperty("操作人编码")
    private String czrbm;

    @ApiModelProperty("出入库时间结束时间")
    private String jssj;

    @ApiModelProperty("出入库时间开始时间")
    private String kssj;

    @ApiModelProperty(value = "物品分类编码")
    private String wpflbm;
}
