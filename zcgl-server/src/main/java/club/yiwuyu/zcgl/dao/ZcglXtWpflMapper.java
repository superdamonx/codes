package club.yiwuyu.zcgl.dao;

import club.yiwuyu.zcgl.dto.wpflgl.WpflglDeleteInputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglKcOutputDTO;
import club.yiwuyu.zcgl.model.ZcglXtWpfl;
import club.yiwuyu.zcgl.query.WpflQueryOutputDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface ZcglXtWpflMapper {
    /**
     * 添加新的物品分类信息
     *
     * @param zcglXtWpfl
     * @return 影响行数（0：失败；1：成功）
     */
    int insert(ZcglXtWpfl zcglXtWpfl);

    /**
     * 查询出最大序号的分类信息
     *
     * @return 最大序号的分类信息
     */
    ZcglXtWpfl selectMaxXh();

    /**
     * 通过分类名称查询指定的分类信息
     *
     */
    int updateByFlbm(ZcglXtWpfl zcglXtWpfl);

    /**
     * 将所有大于等于该序号的分类信息自身的分类序号全部加一
     * @param flxh
     * @return
     */
    int autoIncrementFlxh(Integer flxh);

    int deleteById(ZcglXtWpfl zcglXtWpfl);

    List<ZcglXtWpfl> findByFlbm(String flmc);

    List<ZcglXtWpfl> findBy(String flmc);

    List<ZcglXtWpfl> findAllFl();

    List<WpflglKcOutputDTO> selectAll();
}
