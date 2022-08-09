package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户登录输出参数")
public class LoginOutputDTO {

    @ApiModelProperty("人员编码")
    private String rybm;

    @ApiModelProperty("人员名称")
    private String rymc;

    @ApiModelProperty("性别")
    private String xb;

    @ApiModelProperty("功能权限")
    private String gnqx;

    @ApiModelProperty("访问令牌")
    private String token;
}
