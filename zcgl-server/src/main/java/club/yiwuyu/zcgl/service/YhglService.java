package club.yiwuyu.zcgl.service;

import club.yiwuyu.zcgl.dto.yhgl.*;
import club.yiwuyu.zcgl.query.RybmQueryOutputDTO;

import java.util.List;

public interface YhglService {

    LoginOutputDTO login(LoginInputDTO inputDTO);

    AddOutputDTO add(AddInputDTO inputDTO);

    boolean del(DelInputDTO inputDTO);

    UpdateOutputDTO upd(UpdateInputDTO inputDTO);

    List<RybmQueryOutputDTO> query();
}
