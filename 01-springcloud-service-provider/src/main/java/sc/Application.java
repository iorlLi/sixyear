package sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("sc.mapper") //有了这个注解，其他mapper就不要加注解了
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        //返回的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //System.out.println(beanDefinitionName);
        }
    }

}
