package club.yiwuyu.zcgl.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户信息")
public class UserInfo {
    @ApiModelProperty("人员编码")
    private String rybm;

    @ApiModelProperty("人员名称")
    private String rymc;
}
