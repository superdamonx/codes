package club.yiwuyu.zcgl.model;

import lombok.Data;

import java.util.Date;

/**
 * 物品分类
 */
@Data
public class ZcglXtWpfl {
    /**
     * 分类编码
     */
    private String flbm;
    private String flmc;
    private String tplj;
    private String jldw;
    private Integer flxh;
    private String flsm;
    private String bz;
    private String sfsc;
    private Date cjsj;
    private Date zhxgsj;
}