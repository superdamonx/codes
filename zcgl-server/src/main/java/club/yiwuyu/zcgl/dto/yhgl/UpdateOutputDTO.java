package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel("修改用户信息输出参数")

public class UpdateOutputDTO {

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

    @ApiModelProperty("是否删除")
    private String sfsc;

    @ApiModelProperty("创建时间")
    private Timestamp cjsj;

    @ApiModelProperty("最后修改时间")
    private Timestamp zhxgsj;
}
