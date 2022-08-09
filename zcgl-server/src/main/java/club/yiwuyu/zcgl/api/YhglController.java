package club.yiwuyu.zcgl.api;

import club.yiwuyu.zcgl.dto.yhgl.*;
import club.yiwuyu.zcgl.query.RybmQueryOutputDTO;
import club.yiwuyu.zcgl.service.YhglService;
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

@Api(tags = "用户管理")
@RestController
@RequestMapping("yhgl")
public class YhglController {
    @Resource
    private YhglService yhglService;

    //登录接口
    @ApiOperation("登录")
    @PostMapping("/login")
    @ApiOperationSupport(order = 1)
    public LoginOutputDTO login(@RequestBody @Validated LoginInputDTO inputDTO) {
        return yhglService.login(inputDTO);
    }

    //添加用户的接口
    @ApiOperation("添加用户")
    @PostMapping("/add")
    @ApiOperationSupport(order = 2)
    public JsonResult<AddOutputDTO> add(@RequestBody @Validated AddInputDTO inputDTO) {
        AddOutputDTO responseData = yhglService.add(inputDTO);
        return responseData.getState() ? JsonResult.success(responseData) : JsonResult.failed(-1, responseData.getMessage());
    }

    //删除用户的接口
    @ApiOperation("删除用户")
    @PostMapping("/delete")
    @ApiOperationSupport(order = 3)
    public JsonResult<Boolean> delete(@RequestBody @Validated DelInputDTO inputDTO){
        boolean delResult = yhglService.del(inputDTO);
        return JsonResult.success(delResult);
    }

    //更改用户信息
    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    @ApiOperationSupport(order = 4)
    public UpdateOutputDTO upd(@RequestBody @Validated UpdateInputDTO inputDTO){
        return yhglService.upd(inputDTO);
    }

    //查询用户信息
    @ApiOperation("查询用户")
    @PostMapping("/query")
    @ApiOperationSupport(order = 5)
    public List<RybmQueryOutputDTO> queryyh(){
        return yhglService.query();
    }

}
