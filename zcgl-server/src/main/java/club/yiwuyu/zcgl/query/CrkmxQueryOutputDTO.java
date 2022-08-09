package club.yiwuyu.zcgl.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("查询出入库记录输出参数")
public class CrkmxQueryOutputDTO {

    @ApiModelProperty("出入库编号")
    private String crkbh;

    @ApiModelProperty("出入库类型")
    private String crklx;

    @ApiModelProperty("资产分类")
    private String wpflmc;

    @ApiModelProperty("出入库数量")
    private int wpsl;

    @ApiModelProperty("登记人")
    private String czrmc;

    @ApiModelProperty("登记时间")
    private Date crksj;

    @ApiModelProperty("出入库说明")
    private String crksm;

}
