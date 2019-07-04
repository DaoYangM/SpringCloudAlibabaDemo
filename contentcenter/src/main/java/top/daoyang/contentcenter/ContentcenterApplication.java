package top.daoyang.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("top.daoyang")
@SpringBootApplication
public class ContentcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentcenterApplication.class, args);
    }

}