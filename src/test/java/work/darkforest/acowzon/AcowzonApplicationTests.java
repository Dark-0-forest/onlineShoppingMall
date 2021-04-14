package work.darkforest.acowzon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import work.darkforest.acowzon.mapper.AddressMapper;
import work.darkforest.acowzon.mapper.LoginMapper;

import java.util.Date;

@SpringBootTest
class AcowzonApplicationTests {
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    AddressMapper addressMapper;

    @Test
    void contextLoads() {
        Date date = new Date();
        System.out.println(date);

    }

}