package club.yiwuyu.zcgl.config;

import com.newbie.core.security.util.UserManager;
import com.tfswx.oplog.OperationLogUserTokenService;
import org.springframework.stereotype.Service;

@Service
public class OperationLogUserTokenServiceImpl implements OperationLogUserTokenService {
    @Override
    public String getRybm() {
        UserInfo userInfo = UserManager.getContext("user_info");
        return userInfo.getRybm();
    }

    @Override
    public String getRymc() {
        UserInfo userInfo = UserManager.getContext("user_info");
        return userInfo.getRymc();
    }
}
