package club.yiwuyu.zcgl.service;

import club.yiwuyu.zcgl.dto.wpflgl.WpflglAddInputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglDeleteInputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglKcOutputDTO;
import club.yiwuyu.zcgl.dto.wpflgl.WpflglUpdateInputDTO;
import club.yiwuyu.zcgl.query.WpflQueryOutputDTO;

import java.util.List;

public interface WpflglService {

    boolean add(WpflglAddInputDTO inputDTO);

    boolean del(WpflglDeleteInputDTO inputDTO);

    boolean updateFl(WpflglUpdateInputDTO inputDTO);

    List<WpflQueryOutputDTO> querywpfl();

    List<WpflglKcOutputDTO> querywpkc();
}