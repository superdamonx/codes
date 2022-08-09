package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("用户登录输入参数")
public class LoginInputDTO {

    @NotBlank
    @ApiModelProperty(value = "登录别名",required = true)
    private String dlbm;

    @NotBlank
    @ApiModelProperty(value = "登录口令",required = true)
    private String dlkl;
}
