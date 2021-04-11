package work.darkforest.acowzon;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.darkforest.acowzon.mapper")
public class AcowzonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcowzonApplication.class, args);
    }

}
