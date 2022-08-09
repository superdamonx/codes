package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询用户的输出参数")
public class QueryOutputDTO {

    @ApiModelProperty("功能权限")
    private String gnqx;

    @ApiModelProperty("人员姓名")
    private String rymc;

    @ApiModelProperty("性别")
    private String xb;

    @ApiModelProperty("登陆别名")
    private String dlbm;

}
