package club.yiwuyu.zcgl.dao;

import club.yiwuyu.zcgl.dto.crkmx.CrkmxUpdateInputDTO;
import club.yiwuyu.zcgl.model.ZcglYxCrkmx;
import club.yiwuyu.zcgl.query.CrkmxQueryInputDTO;
import club.yiwuyu.zcgl.query.CrkmxQueryOutputDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper
public interface ZcglYxCrkmxMapper extends BaseMapper<ZcglYxCrkmx> {

    //检查是否存在当前分类的操作
    List<ZcglYxCrkmx> che(String wpflmc);

    //添加出入库操作中修改当前的数据
    int insert(ZcglYxCrkmx zcglYxCrkmx);

    //删除出入库信息的操作
    int deleteByCrkbh(ZcglYxCrkmx zcglYxCrkmx);

    //查询出入库记录信息
    List<ZcglYxCrkmx> getAll(ZcglYxCrkmx zcglYxCrkmx);

    List<ZcglYxCrkmx> find(CrkmxUpdateInputDTO inputDTO);

    int updateByBh();

    List<CrkmxQueryOutputDTO> query(CrkmxQueryInputDTO filter);
}
