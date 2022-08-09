package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("删除用户输入参数")
public class DelInputDTO {

    @NotBlank
    @ApiModelProperty(value = "人员编码",required = true)
    private String rybm;
}
