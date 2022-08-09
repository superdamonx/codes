package club.yiwuyu.zcgl.service.impl;

import club.yiwuyu.zcgl.config.UserInfo;
import club.yiwuyu.zcgl.constant.ZcglConst;
import club.yiwuyu.zcgl.dao.ZcglYxCrkmxMapper;
import club.yiwuyu.zcgl.dto.crkmx.*;
import club.yiwuyu.zcgl.model.ZcglYxCrkmx;
import club.yiwuyu.zcgl.query.CrkmxQueryInputDTO;
import club.yiwuyu.zcgl.query.CrkmxQueryOutputDTO;
import club.yiwuyu.zcgl.service.CrkmxService;
import club.yiwuyu.zcgl.util.page.ConverterUtils;
import club.yiwuyu.zcgl.util.page.PageHelper;
import club.yiwuyu.zcgl.util.page.PageParam;
import club.yiwuyu.zcgl.util.page.PageResult;
import com.newbie.core.security.util.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CrkmxServiceImpl implements CrkmxService {
    @Resource
    ZcglYxCrkmxMapper zcglYxCrkmxMapper;


    @Override
    public boolean add(CrkmxAddInputDTO inputDTO) {

        //1.先判断物品分类是否存在
        List<ZcglYxCrkmx> check = zcglYxCrkmxMapper.che(inputDTO.getWpflmc());
        ZcglYxCrkmx zcglYxCrkmx = new ZcglYxCrkmx();
        if (check.size() <= 0){
            throw new RuntimeException("分类不存在，请先添加分类");
        }
        log.info("分类有效：{}", inputDTO.getWpflmc());

        //进行设置相关参数
//        Date now = new Date(System.currentTimeMillis());
        Date now = new Date(System.currentTimeMillis());
        zcglYxCrkmx.setCjsj(now);
        zcglYxCrkmx.setCjsj(now);
        zcglYxCrkmx.setCrksj(now);
        zcglYxCrkmx.setWpflmc(inputDTO.getWpflmc());
        UserInfo userInfo = UserManager.getContext("user_info");
        zcglYxCrkmx.setCzrmc(userInfo.getRymc());
        zcglYxCrkmx.setCrksm(inputDTO.getCrksm());
        zcglYxCrkmx.setWpflbm(inputDTO.getWpflbm());
        zcglYxCrkmx.setCzrmc(userInfo.getRymc());
        zcglYxCrkmx.setCzrbm(userInfo.getRybm());
        zcglYxCrkmx.setWpsl(inputDTO.getWpsl());
        zcglYxCrkmx.setSfsc(ZcglConst.SFSC_N);
        zcglYxCrkmx.setBz("");

        //生成编号
        zcglYxCrkmx.setCrkbh(UUID.randomUUID().toString().replace("-", ""));

        int addnumber = zcglYxCrkmxMapper.insert(zcglYxCrkmx);
        //返回是否添加成功
        return addnumber == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    //删除出入库信息
    @Override
    public boolean del(CrkmxDeleteInputDTO inputDTO) {
        //验证是否登录
        UserManager.getContext("user_info");
        ZcglYxCrkmx zcglYxCrkmx = new ZcglYxCrkmx();
        return zcglYxCrkmxMapper.deleteByCrkbh(zcglYxCrkmx) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    //查询出入库记录信息
    @Override
    public List<CrkmxGetOutputDTO> geter(CrkmxGetInputDTO inputDTO) {
        //1.验证登陆状态
        UserManager.getContext("user_info");
        //2.数据的初始化
        ZcglYxCrkmx zcglYxCrkmx = new ZcglYxCrkmx();
        zcglYxCrkmx.setCrkbh(inputDTO.getCrkbh());
        zcglYxCrkmx.setCrklx("");
        zcglYxCrkmx.setCrksj(new Date(0));
        zcglYxCrkmx.setCrksm("");
        zcglYxCrkmx.setCzrbm("");
        zcglYxCrkmx.setCzrmc("");
        zcglYxCrkmx.setWpsl( 0);
        List<ZcglYxCrkmx> list = zcglYxCrkmxMapper.getAll(zcglYxCrkmx);
        List<CrkmxGetOutputDTO> outputDTOList = new ArrayList<>();
        for (ZcglYxCrkmx zcglYxCrkmx1 : list){
            CrkmxGetOutputDTO outputDTO = ConverterUtils.convert(zcglYxCrkmx1,CrkmxGetOutputDTO.class);
            outputDTOList.add(outputDTO);
        }
        if (list.size() <= 0){
            throw new RuntimeException("没有该编号的信息哦~请检查是否输入正确");
        }
        return outputDTOList;
    }

    //查询出入库记录
    @Override
    public PageResult<CrkmxQueryOutputDTO> query(PageParam<CrkmxQueryInputDTO> inputDTOPageParam) {

        //1.验证登陆信息
        UserManager.getContext("user_info");

        //2.设置参数进行输出,使用pagehelper
        PageResult<CrkmxQueryOutputDTO> crkmxQueryOutputDTOPageResult = PageHelper.doSelectPage(inputDTOPageParam,()->
        {
            zcglYxCrkmxMapper.query(inputDTOPageParam.getFilter());
        });

        return crkmxQueryOutputDTOPageResult;
    }


    //修改出入库明细
    @Override
    public boolean update(CrkmxUpdateInputDTO inputDTO) {
        //验证登录状态
        UserManager.getContext("user_info");
        //数据拷贝
        ZcglYxCrkmx zcglYxCrkmx = new ZcglYxCrkmx();
        zcglYxCrkmx.setCrksm(inputDTO.getCrksm());
        zcglYxCrkmx.setWpflmc(inputDTO.getWpflmc());
        zcglYxCrkmx.setWpflbm(inputDTO.getWpflbm());
        zcglYxCrkmx.setWpsl(inputDTO.getWpsl());
        zcglYxCrkmx.setCrkbh(inputDTO.getCrkbh());
        //验证是否有修改成功
        int updateSum = zcglYxCrkmxMapper.updateByBh();
        return updateSum > 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}
