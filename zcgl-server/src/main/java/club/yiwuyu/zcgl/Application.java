package club.yiwuyu.zcgl;

import com.tfswx.oplog.EnableOperationLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//Author:向景梁
@EnableOperationLog
@EnableScheduling
@MapperScan("club.yiwuyu.zcgl.dao")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
