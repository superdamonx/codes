package club.yiwuyu.zcgl.api;

import club.yiwuyu.zcgl.dto.wpflgl.WpflglAddInputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglDeleteInputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglKcOutputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglUpdateInputDTO;
import club.yiwuyu.zcgl.query.WpflQueryOutputDTO;
import club.yiwuyu.zcgl.service.WpflglService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.newbie.core.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "物品分类管理")
@RequestMapping("/wpflgl")
@RestController
public class WpflglController {

    @Resource
    WpflglService wpflglService;

    @ApiOperation("添加分类")
    @PostMapping("/add")
    @ApiOperationSupport(order = 1)
    public JsonResult<Boolean> add(@RequestBody @Validated WpflglAddInputDTO inputDTO) {
        boolean addResult = wpflglService.add(inputDTO);
        return JsonResult.success(addResult);
    }

    @ApiOperation("删除分类")
    @PostMapping("/delete")
    @ApiOperationSupport(order = 2)
    public JsonResult<Boolean> delete(@RequestBody @Validated WpflglDeleteInputDTO inputDTO){
        boolean delResult = wpflglService.del(inputDTO);
        return JsonResult.success(delResult);
    }

    @ApiOperation("修改分类信息")
    @PostMapping("/update")
    @ApiOperationSupport(order = 3)
    public JsonResult<Boolean> update(@RequestBody @Validated WpflglUpdateInputDTO inputDTO){
        boolean updateResult = wpflglService.updateFl(inputDTO);
        return JsonResult.success(updateResult);
    }

    @ApiOperation("查询分类")
    @PostMapping("/query")
    @ApiOperationSupport(order = 4)
    public List<WpflQueryOutputDTO> queryfl(){
        return wpflglService.querywpfl();
    }

    @ApiOperation("查询分类库存")
    @PostMapping("/queryFlkc")
    @ApiOperationSupport(order = 4)
    public List<WpflglKcOutputDTO> querykc(){
        return wpflglService.querywpkc();
    }
}