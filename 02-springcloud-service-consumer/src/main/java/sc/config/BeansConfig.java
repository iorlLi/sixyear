package sc.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {
//客户端提供负载均衡
    @LoadBalanced//ribbon：consumer使用负载均衡调用provider
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //覆盖掉ribbon的默认(轮询)的策略
   // @Bean
    public IRule iRule() {
        return  new RandomRule();//随机策略
    }

}
