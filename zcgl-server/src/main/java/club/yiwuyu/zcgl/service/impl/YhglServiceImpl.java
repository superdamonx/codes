package club.yiwuyu.zcgl.service.impl;

import ch.qos.logback.core.pattern.ConverterUtil;
import club.yiwuyu.zcgl.config.UserInfo;
import club.yiwuyu.zcgl.constant.YhglConst;
import club.yiwuyu.zcgl.constant.ZcglConst;
import club.yiwuyu.zcgl.util.page.ConverterUtils;
import club.yiwuyu.zcgl.dao.ZzjgXtRybmMapper;
import club.yiwuyu.zcgl.dto.yhgl.*;
import club.yiwuyu.zcgl.model.ZzjgXtRybm;
import club.yiwuyu.zcgl.query.RybmQueryOutputDTO;
import club.yiwuyu.zcgl.service.YhglService;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.MD5;
import com.newbie.core.exception.BusinessException;
import com.newbie.core.security.util.TokenInfo;
import com.newbie.core.security.util.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class YhglServiceImpl implements YhglService {
    @Resource
    ZzjgXtRybmMapper zzjgXtRybmMapper;

    /**
     * 登录口令校验
     */
    private final static String PASSWORD_SALT = "*GZ7~{;a8>Kia4";

    @Override
    public LoginOutputDTO login(LoginInputDTO inputDTO) {

        // 1.获取用户信息
        ZzjgXtRybm zzjgXtRybm = new ZzjgXtRybm();
        zzjgXtRybm.setDlbm(inputDTO.getDlbm());
        ZzjgXtRybm result = zzjgXtRybmMapper.get(zzjgXtRybm);

        if (result == null || !result.getDlkl().equals(MD5.create().digestHex(inputDTO.getDlkl() + PASSWORD_SALT))) {
            throw new BusinessException("用户名或密码错误");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setRybm(result.getRybm());
        userInfo.setRymc(result.getRymc());

        // 2.SA登录
        UserManager.login(userInfo.getRybm());

        // 3.缓存用户信息
        UserManager.setContext("user_info", userInfo);

        // 4.获取token
        TokenInfo tokenInfo = UserManager.getTokenInfo();

        // 5.构造输出参数
        LoginOutputDTO outputDTO = new LoginOutputDTO();
        outputDTO.setRybm(userInfo.getRybm());
        outputDTO.setRymc(userInfo.getRymc());
        outputDTO.setXb(result.getXb());
        outputDTO.setGnqx(result.getGnqx());
        outputDTO.setToken(tokenInfo.tokenValue);

        return outputDTO;
    }


    //添加用户
    @Override
    public AddOutputDTO add(AddInputDTO inputDTO) {

        //1.先进行权限验证
        UserInfo userInfo = UserManager.getContext("user_info");
        String Rybm = userInfo.getRybm();
        ZzjgXtRybm zzjgXtRybm1 = new ZzjgXtRybm();
        zzjgXtRybm1.setGnqx(zzjgXtRybmMapper.getGnqx(Rybm));
        if (zzjgXtRybm1.getGnqx().equals("系统管理员")){
            throw new RuntimeException("您没有权限哦~");
        }

        // 2.先获取信息
        AddOutputDTO outputDTO = new AddOutputDTO();
        ZzjgXtRybm zzjgXtRybm = new ZzjgXtRybm();
        zzjgXtRybm.setDlbm(inputDTO.getDlbm());

        // 3.检查用户是否存在
        int countDlbm = zzjgXtRybmMapper.checkDlbm(zzjgXtRybm);
        if (countDlbm > 0) {
            outputDTO.setState(false);
            outputDTO.setMessage("用户别名已存在，添加失败");
            return outputDTO;
        } else {
            zzjgXtRybm.setRybm(UUID.randomUUID().toString().replace("-", ""));
            zzjgXtRybm.setRymc(inputDTO.getRymc());
            zzjgXtRybm.setGnqx(inputDTO.getGnqx());
            zzjgXtRybm.setXb(inputDTO.getXb());
            zzjgXtRybm.setSfsc("N");
            outputDTO.setState(true);
            outputDTO.setMessage("添加成功");
            outputDTO.setNewRybm(zzjgXtRybm.getRybm());
            return outputDTO;
        }
    }

    //删除用户
    @Override
    public boolean del(DelInputDTO inputDTO) {

        //1.先验证功能权限
        UserInfo userInfo = UserManager.getContext("user_info");
        String Rybm = userInfo.getRybm();
        ZzjgXtRybm zzjgXtRybm = new ZzjgXtRybm();
        zzjgXtRybm.setGnqx(zzjgXtRybmMapper.getGnqx(Rybm));
        if (!zzjgXtRybm.getGnqx().equals("系统管理员")){
            throw new RuntimeException("您没有该权限");
        }

        //进行删除操作
        zzjgXtRybm.setRybm(inputDTO.getRybm());
        int countRybm = zzjgXtRybmMapper.delRy(inputDTO.getRybm());
        //返回是否删除成功
        return countRybm == 1;
    }


    //修改用户信息
    @Override
    public UpdateOutputDTO upd(UpdateInputDTO inputDTO){

        //验证登陆状态
        UserManager.getContext("user_info");

        //修改参数
        UpdateOutputDTO updateOutputDTO = new UpdateOutputDTO();
        ZzjgXtRybm tjyh = BeanUtil.copyProperties(inputDTO,ZzjgXtRybm.class);
        tjyh.setZhxgsj(DateUtil.date().toTimestamp());
        tjyh.setRybm(inputDTO.getRybm());
        tjyh.setRymc(inputDTO.getRymc());
        tjyh.setGnqx(inputDTO.getGnqx());
        tjyh.setXb(inputDTO.getXb());
        tjyh.setRymc(inputDTO.getRymc());
        tjyh.setSfsc("N");
        updateOutputDTO.setGnqx(tjyh.getGnqx());
        updateOutputDTO.setRymc(tjyh.getRymc());
        updateOutputDTO.setXb(tjyh.getXb());
        updateOutputDTO.setRybm(tjyh.getRybm());

        //返回需要输出的参数
        return updateOutputDTO;
    }

    //查询用户信息
    @Override
    public List<RybmQueryOutputDTO> query() {

        //先验证功能权限
        UserInfo userInfo = UserManager.getContext("user_info");
        String Rybm = userInfo.getRybm();
        RybmQueryOutputDTO outputDTO = new RybmQueryOutputDTO();
        outputDTO.setGnqx(zzjgXtRybmMapper.getGnqx(Rybm));
        if (!outputDTO.getGnqx().equals("系统管理员")){
            throw new RuntimeException("您没有该权限");
        }

        //查询返回
        List<ZzjgXtRybm> list = zzjgXtRybmMapper.queryAll();
        List<RybmQueryOutputDTO> queryList = new ArrayList<>();
        for (ZzjgXtRybm zzjgXtRybm : list) {
            RybmQueryOutputDTO outputDTO1 = ConverterUtils.convert(zzjgXtRybm, RybmQueryOutputDTO.class);
            queryList.add(outputDTO1);
        }

        return queryList;
    }

}
