package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.security.SecureRandom;

@Data
@ApiModel("修改用户信息输入参数")
public class UpdateInputDTO {

    @ApiModelProperty("功能权限")
    private String gnqx;

    @NotBlank
    @ApiModelProperty(value = "人员编码",required = true)
    private String rybm;

    @ApiModelProperty("人员名称")
    private String rymc;

    @ApiModelProperty("性别")
    private String xb;

}
