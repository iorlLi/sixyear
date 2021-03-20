package sc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sc.mapper.CityMapper;
import sc.model.City;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    CityMapper cityMapper;
    @Test
    public void testUser() {
        City city = cityMapper.selectById(1);
        System.out.println(city);
    }

}
