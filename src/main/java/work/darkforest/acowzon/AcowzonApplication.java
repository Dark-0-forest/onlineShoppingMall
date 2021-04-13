package work.darkforest.acowzon;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("work.darkforest.acowzon.mapper")
@EnableSwagger2    // 开启swagger2
public class AcowzonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcowzonApplication.class, args);
    }

}
