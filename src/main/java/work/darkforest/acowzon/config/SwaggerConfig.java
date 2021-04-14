package work.darkforest.acowzon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){
        // 设置要启动swagger的环境名
        Profiles profiles = Profiles.of("dev");
        // 通过environment.acceptsProfiles监听当前的环境是不是需要开启swagger
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("darkforest")
                .enable(flag)
                .apiInfo(apiInfo());
    }

    // 配置swagger的信息
    private ApiInfo apiInfo(){
        // 作者信息 姓名，地址，邮箱
        Contact contact = new Contact("darkforest", "http://www.darkforest.work/", "92774025@qq.com");
        return new ApiInfo(
                "Darkforest的接口API",    /*标题*/
                "API文档",    /*描述*/
                "v1.0",      /*版本号*/
                "http://www.darkforest.work/",  /*团队的服务器url*/
                contact, /*作者信息*/
                "Apache 2.0",     /*默认即可*/
                "http://www.apache.org/licenses/LICENSE-2.0",    /*默认即可*/
                new ArrayList()); /*标题*/
    }
}
