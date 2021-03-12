package sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("sc.mapper") //有了这个注解，其他mapper就不要加注解了
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
