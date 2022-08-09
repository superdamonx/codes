package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("添加用户输入参数")
public class AddInputDTO {

    @NotBlank(message = "登录别名不能为空")
    @ApiModelProperty(value = "登录别名",required = true)
    private String dlbm;

    @NotBlank(message = "登录口令不能为空")
    @ApiModelProperty(value = "登录口令",required = true)
    private String dlkl;

    @NotBlank(message = "功能权限不能为空")
    @ApiModelProperty("功能权限")
    private String gnqx;

    @NotBlank(message = "人员名称不能为空")
    @ApiModelProperty(value = "人员名称",required = true)
    private String rymc;

    @ApiModelProperty("性别")
    private String xb;
}
