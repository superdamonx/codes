package club.yiwuyu.zcgl.util.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("分页查询输出参数")
public class PageResult<T> {
    @ApiModelProperty("总数")
    private Long total;

    @ApiModelProperty("列表")
    private List<T> list;
}
