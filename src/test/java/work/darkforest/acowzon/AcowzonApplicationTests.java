package work.darkforest.acowzon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AcowzonApplicationTests {


    @Test
    void contextLoads() {
        Date date = new Date();
        System.out.println(date);
    }

}