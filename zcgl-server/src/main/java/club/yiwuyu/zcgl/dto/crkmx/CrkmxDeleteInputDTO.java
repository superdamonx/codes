package club.yiwuyu.zcgl.dto.crkmx;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("删除出入库明细输入参数")
public class CrkmxDeleteInputDTO {

    @NotBlank(message = "不能为空~")
    @ApiModelProperty(value = "出入库编号",required = true)
    private String crkbh;
}
