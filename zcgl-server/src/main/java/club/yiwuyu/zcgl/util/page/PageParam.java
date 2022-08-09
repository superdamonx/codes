package club.yiwuyu.zcgl.util.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("分页查询输入参数")
public class PageParam<T> {
    @ApiModelProperty(value = "页码", example = "1")
    @NotNull(message = "pageNum-不能为空")
    @Min(value = 1, message = "pageNum-不能小于1")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "页容量", example = "20")
    @NotNull(message = "pageSize-不能为空")
    @Min(value = 1, message = "pageSize-不能小于1")
    private Integer pageSize = 20;

    @ApiModelProperty("排序字段")
    private String orderBy;

    @ApiModelProperty("过滤Dto对象")
    @Valid
    @NotNull(message = "filter-不能为空")
    private T filter;
}
