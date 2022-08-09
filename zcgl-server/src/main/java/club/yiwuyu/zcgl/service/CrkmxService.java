package club.yiwuyu.zcgl.service;

import club.yiwuyu.zcgl.dto.crkmx.*;
import club.yiwuyu.zcgl.model.ZcglYxCrkmx;
import club.yiwuyu.zcgl.query.CrkmxQueryInputDTO;
import club.yiwuyu.zcgl.query.CrkmxQueryOutputDTO;
import club.yiwuyu.zcgl.util.page.PageParam;
import club.yiwuyu.zcgl.util.page.PageResult;

import java.util.List;

public interface CrkmxService {

    boolean add(CrkmxAddInputDTO inputDTO);

    boolean del(CrkmxDeleteInputDTO inputDTO);

    List<CrkmxGetOutputDTO> geter(CrkmxGetInputDTO inputDTO);

    //查询出入库记录
    PageResult<CrkmxQueryOutputDTO> query(PageParam<CrkmxQueryInputDTO> inputDTOPageParam);

    boolean update(CrkmxUpdateInputDTO inputDTO);
}
