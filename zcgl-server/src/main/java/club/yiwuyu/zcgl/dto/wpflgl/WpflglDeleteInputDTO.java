package club.yiwuyu.zcgl.dto.wpflgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("删除分类输入参数")
public class WpflglDeleteInputDTO {

    @NotBlank
    @ApiModelProperty(value = "分类编码",required = true)
    private String flbm;
}
