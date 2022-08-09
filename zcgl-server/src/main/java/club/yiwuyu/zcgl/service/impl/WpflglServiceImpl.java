package club.yiwuyu.zcgl.service.impl;

import club.yiwuyu.zcgl.constant.ZcglConst;
import club.yiwuyu.zcgl.dao.ZcglXtWpflMapper;
import club.yiwuyu.zcgl.dto.wpflgl.*;
import club.yiwuyu.zcgl.model.ZcglXtWpfl;
import club.yiwuyu.zcgl.query.WpflQueryOutputDTO;
import club.yiwuyu.zcgl.service.WpflglService;
import club.yiwuyu.zcgl.util.page.ConverterUtils;
import com.newbie.core.exception.BusinessException;
import com.newbie.core.security.util.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class WpflglServiceImpl implements WpflglService {

    @Resource
    ZcglXtWpflMapper zcglXtWpflMapper;

    public List<WpflQueryOutputDTO> queryFl() {
        return null;
    }

    //添加用户信息
    @Override
    public boolean add(WpflglAddInputDTO inputDTO) {

        // 1、判断分类名称是否已经存在，如果存在则不允许添加
        List<ZcglXtWpfl> bys = zcglXtWpflMapper.findBy(inputDTO.getFlmc());
        if (bys.size() > 0) {
            throw new RuntimeException("分类名称已经存在：" + inputDTO.getFlmc());
        }
        log.info("分类名称检测有效：{}", inputDTO.getFlmc());

        ZcglXtWpfl zcglXtWpfl = new ZcglXtWpfl();

        // 2、拷贝不需要更改的数据
        zcglXtWpfl.setFlmc(inputDTO.getFlmc());
        zcglXtWpfl.setFlsm(inputDTO.getFlsm());
        zcglXtWpfl.setJldw(inputDTO.getJldw());
        zcglXtWpfl.setTplj(inputDTO.getTplj());

        // 3、生成ID
        String flbm = UUID.randomUUID().toString().replace("-", "");
        zcglXtWpfl.setFlbm(flbm);
        log.info("新生成分类编码：{}", flbm);

        /*
         * 4、序号业务：
         *     a、如果用户传入了序号，就用用户指定的序号
         *     b、如果用户没有传入序号，就找到当前序号最大值，把新加的数据设置为最大值加一；
         * */
        if (inputDTO.getFlxh() == null) {
            // 没有传入
            int flxh;
            ZcglXtWpfl maxZcglXtWpfl = zcglXtWpflMapper.selectMaxXh();
            if (maxZcglXtWpfl == null) {
                flxh = 1;
            } else {
                flxh = maxZcglXtWpfl.getFlxh() + 1;
            }
            zcglXtWpfl.setFlxh(flxh);
            log.info("自动计算得出当前新增数据的序号应该为：{}", flxh);
        } else {
            // 传入了
            zcglXtWpfl.setFlxh(inputDTO.getFlxh());
            // 因为是人工指定的分类序号，所以多加个操作，将该序号及该序号之后所有的序号都先加一，把当前需要插入的数据位的序号让出来
            int bcdNumber = zcglXtWpflMapper.autoIncrementFlxh(zcglXtWpfl.getFlxh());
            log.info("【{}】个对象的序号被顶到了后面", bcdNumber);
        }

        // 5、系统字段维护
        Date now = new Date();
        zcglXtWpfl.setCjsj(now);
        zcglXtWpfl.setZhxgsj(now);
        zcglXtWpfl.setSfsc(ZcglConst.SFSC_N);

        int insertNumber = zcglXtWpflMapper.insert(zcglXtWpfl);

        log.info("添加成功：{}", zcglXtWpfl);
        return insertNumber == 1;
    }


    //删除分类信息
    @Override
    public boolean del(WpflglDeleteInputDTO inputDTO){
        //验证登陆状态
        UserManager.getContext("user_info");
        //返回是否删除成功
        ZcglXtWpfl zcglXtWpfl = new ZcglXtWpfl();
        return zcglXtWpflMapper.deleteById(zcglXtWpfl) > 0 ? Boolean.TRUE :Boolean.FALSE;
    }


    //修改分类信息
    @Override
    public boolean updateFl(WpflglUpdateInputDTO inputDTO){
        //验证登陆状态
        UserManager.getContext("user_info");

        //2.进行值的拷贝
        ZcglXtWpfl zcglXtWpfl = new ZcglXtWpfl();
        zcglXtWpfl.setFlbm(inputDTO.getFlbm());
        zcglXtWpfl.setFlxh(inputDTO.getFlxh());
        zcglXtWpfl.setFlsm(inputDTO.getFlsm());
        zcglXtWpfl.setJldw(inputDTO.getJldw());
        zcglXtWpfl.setTplj(inputDTO.getTplj());
        zcglXtWpfl.setFlmc(inputDTO.getFlmc());
        //3.进行验证是否有该分类
        List<ZcglXtWpfl> gx = zcglXtWpflMapper.findByFlbm(inputDTO.getFlbm());
        if (gx.size() <= 0) {
            log.info("分类检测无效：{}", inputDTO.getFlmc());
            throw new RuntimeException("该分类不存在：" + inputDTO.getFlbm());
        }
        log.info("进行修改");
        //通过非空项分类编码进行查询修改并返回
        return zcglXtWpflMapper.updateByFlbm(zcglXtWpfl) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    //查询分类信息
    @Override
    public List<WpflQueryOutputDTO> querywpfl(){
        //1.验证登录状态
        UserManager.getContext("user_info");

        //2.进行查询并取出值
        List<ZcglXtWpfl> list = zcglXtWpflMapper.findAllFl();
        List<WpflQueryOutputDTO> queryOutputDTOList = new ArrayList<>();
        for (ZcglXtWpfl zcglXtWpfl : list){
            WpflQueryOutputDTO outputDTO = ConverterUtils.convert(zcglXtWpfl,WpflQueryOutputDTO.class);
            queryOutputDTOList.add(outputDTO);
        }
        return queryOutputDTOList;
    }

    //查询分类库存信息
    @Override
    public List<WpflglKcOutputDTO> querywpkc() {
        //1.验证登陆状态
        UserManager.getContext("user_info");

        //2.进行查询取值
        List<WpflglKcOutputDTO> queryList = zcglXtWpflMapper.selectAll();
        return queryList;
    }
}
