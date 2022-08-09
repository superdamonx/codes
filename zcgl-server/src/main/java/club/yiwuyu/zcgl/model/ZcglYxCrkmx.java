package club.yiwuyu.zcgl.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 出入库明细
 */

@Data
@TableName("T_ZCGL_YX_CRKMX")
public class ZcglYxCrkmx {
    @TableId(type = IdType.ASSIGN_UUID)

    private String crkbh;
    private String crklx;
    private String wpflbm;
    private String wpflmc;
    private Integer wpsl;
    private String crksm;
    private String czrbm;
    private String czrmc;
    private Date crksj;
    private String bz;
    private String sfsc = "N";
    private Date cjsj;
    private Date zhxgsj;
}
