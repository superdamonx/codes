package club.yiwuyu.zcgl.dto.wpflgl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改分类信息输出参数")
public class WpflglUpdateOutputDTO {

    @ApiModelProperty("分类编码")
    private String flbm;

    @ApiModelProperty("分类名称")
    private String flmc;

    @ApiModelProperty("分类说明")
    private String flsm;

    @ApiModelProperty("分类序号")
    private Integer flxh;

    @ApiModelProperty("计量单位")
    private String jldw;

    @ApiModelProperty("图片路径")
    private String tplj;

    private String success;
}
