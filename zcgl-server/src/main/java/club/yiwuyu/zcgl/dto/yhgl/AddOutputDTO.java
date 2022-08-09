package club.yiwuyu.zcgl.dto.yhgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加用户的输出参数")
public class AddOutputDTO {

    @ApiModelProperty("添加操作的状态")
    private Boolean state;

    @ApiModelProperty("添加操作的提示")
    private String message;

    @ApiModelProperty("添加成功的人员编码")
    private String newRybm;
}
