package club.yiwuyu.zcgl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@ApiModel("人员信息")
public class RybmQueryOutputDTO {

    @ApiModelProperty("人员编码")
    private String rybm;

    @ApiModelProperty("人员名称")
    private String rymc;

    @ApiModelProperty("性别")
    private String xb;

    @ApiModelProperty("功能权限")
    private String gnqx;

    @ApiModelProperty("登陆别名")
    private String dlbm;

    @NotBlank
    @ApiModelProperty(value = "创建时间",required = true)
    private Date cjsj;
}
