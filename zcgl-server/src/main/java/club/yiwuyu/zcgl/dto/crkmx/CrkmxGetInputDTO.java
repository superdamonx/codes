package club.yiwuyu.zcgl.dto.crkmx;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("查看出入库信息输入参数")
public class CrkmxGetInputDTO {

    @NotBlank
    @ApiModelProperty(value = "出入库编号",required = true)
    private String crkbh;

}
