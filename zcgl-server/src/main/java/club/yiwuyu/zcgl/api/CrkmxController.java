package club.yiwuyu.zcgl.api;

import club.yiwuyu.zcgl.dto.crkmx.*;
import club.yiwuyu.zcgl.model.ZcglYxCrkmx;
import club.yiwuyu.zcgl.query.CrkmxQueryInputDTO;
import club.yiwuyu.zcgl.query.CrkmxQueryOutputDTO;
import club.yiwuyu.zcgl.service.CrkmxService;
import club.yiwuyu.zcgl.util.page.PageParam;
import club.yiwuyu.zcgl.util.page.PageResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.newbie.core.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "出入库明细管理")
@RestController
@RequestMapping("/crkmx")
public class CrkmxController {
    @Resource
    private CrkmxService crkmxService;

    //添加出入库记录
    @ApiOperation("添加出入库记录")
    @PostMapping("/add")
    @ApiOperationSupport(order = 1)
    public JsonResult<Boolean> add(@RequestBody @Validated CrkmxAddInputDTO inputDTO){
        boolean addResult = crkmxService.add(inputDTO);
        return JsonResult.success(addResult);
    }

    @ApiOperation("删除出入库记录")
    @PostMapping("/delete")
    @ApiOperationSupport(order = 2)
    public JsonResult<Boolean> del(@RequestBody @Validated CrkmxDeleteInputDTO inputDTO){
        boolean delResult = crkmxService.del(inputDTO);
        return JsonResult.success(delResult);
    }

    @ApiOperation("获取出入库记录信息")
    @PostMapping("/get")
    @ApiOperationSupport(order = 3)
    public List<CrkmxGetOutputDTO> get(@RequestBody @Validated CrkmxGetInputDTO inputDTO){
        return crkmxService.geter(inputDTO);
    }

    @ApiOperation("查询出入库记录")
    @PostMapping("/query")
    @ApiOperationSupport(order = 4)
    public PageResult<CrkmxQueryOutputDTO> querycrkmx(@RequestBody @Validated PageParam<CrkmxQueryInputDTO> inputDTOPageParam){
        return crkmxService.query(inputDTOPageParam);
    }

    @ApiOperation("修改出入库明细")
    @PostMapping("/update")
    @ApiOperationSupport(order = 5)
    public JsonResult<Boolean> update(@RequestBody @Validated CrkmxUpdateInputDTO inputDTO){
        boolean updateResult = crkmxService.update(inputDTO);
        return JsonResult.success(updateResult);
    }

}
