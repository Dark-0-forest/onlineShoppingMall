package work.darkforest.acowzon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import work.darkforest.acowzon.entity.pojo.Address;
import work.darkforest.acowzon.entity.pojo.Login;
import work.darkforest.acowzon.mapper.AddressMapper;
import work.darkforest.acowzon.mapper.LoginMapper;

import java.util.List;

@SpringBootTest
class AcowzonApplicationTests {
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    AddressMapper addressMapper;

    @Test
    void contextLoads() {
        System.out.println(addressMapper.queryAddressById("2d1ed7bf-4333-4c7a-86cc-043ae27288c6"));

    }

}