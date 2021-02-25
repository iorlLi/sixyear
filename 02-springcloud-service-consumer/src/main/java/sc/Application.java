package sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootApplication
//@EnableEurekaClient//
//@EnableCircuitBreaker//熔断器
@SpringCloudApplication// 1V3版本
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
