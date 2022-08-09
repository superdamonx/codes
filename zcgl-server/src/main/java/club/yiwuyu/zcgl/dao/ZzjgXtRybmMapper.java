package club.yiwuyu.zcgl.dao;

import club.yiwuyu.zcgl.model.ZzjgXtRybm;
import club.yiwuyu.zcgl.query.RybmQueryOutputDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZzjgXtRybmMapper {
    ZzjgXtRybm get(ZzjgXtRybm zzjgXtRybm);

    int checkDlbm(ZzjgXtRybm zzjgXtRybm);


    int checkRybm(ZzjgXtRybm zzjgXtRybm);

    int delRy(String rybm);

    ZzjgXtRybm selectAll(ZzjgXtRybm zzjgXtRybm);

    String getGnqx(String rybm);

    List<ZzjgXtRybm> queryAll();
}
