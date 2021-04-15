package iorl;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "iorl.config")
public class DubboServiceProvider {

    public static void main(String[] args) {
        SpringApplication.run(DubboServiceProvider.class, args);
    }

}
