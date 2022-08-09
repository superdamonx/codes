package club.yiwuyu.zcgl.dto.wpflgl;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WpflglKcOutputDTO {

    @ApiModelProperty("出库数量")
    private Double cksl;

    @ApiModelProperty("分类编码")
    private String flbm;

    @ApiModelProperty("分类名称")
    private String flmc;

    @ApiModelProperty("入库数量")
    private Double rksl;
}
