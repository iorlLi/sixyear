package sc.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sc.hystrixcommand.MyHystrixcommand;
import sc.model.User;

import java.util.concurrent.Future;


@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    /**
     * ignoreExceptions:忽略的异常，如哪些异常需要出发熔断，而哪些异常需要返回错误原因
     * HystrixProperty：可以设置超时等属性
     */
    @HystrixCommand(fallbackMethod = "error", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String hello() {
        //ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/service/hello", String.class);
        //使用ribbon负载均衡可以直接使用服务名称调用
        System.out.println("c hello");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);
        return responseEntity.getBody();
    }

    /**
     * 自定义熔断
     * @return
     *
     * http://localhost:8081/actuator/hystrix.stream
     */
    @RequestMapping("/web/hello2")
    public String hello2() {
        MyHystrixcommand myHystrixcommand;
        myHystrixcommand = new MyHystrixcommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
        //同步调用
        String result = myHystrixcommand.execute();
        //异步调用
        //Future<String> future = myHystrixcommand.queue();
        //ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/service/hello", String.class);
        //使用ribbon负载均衡可以直接使用服务名称调用
        return result;
    }

    public String error(Throwable throwable) {
        System.out.println("异常原因： "+throwable.getMessage());
        return "error";
    }

    @RequestMapping("/web/user")
    public User getUser() {
        // ResponseEntity<User> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user", User.class);

        MultiValueMap<String, String> map = new HttpHeaders();
        map.add("name", "小可爱");
        //使用map的 {key}，多个参数使用  &连接
        //
        ResponseEntity<User> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user?name={name}", User.class, map);
        //只返回对象
        User forObject = restTemplate.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user?name={name}", User.class, map);
        HttpStatus statusCode = entity.getStatusCode();
        int statusCodeValue = entity.getStatusCodeValue();
        HttpHeaders headers = entity.getHeaders();
        User body = entity.getBody();
        System.out.println(statusCodeValue);
        System.out.println(statusCode);
        System.out.println(headers);
        System.out.println(body);
        //返回参数中的calss对象
        //restTemplate.getForObject();
        return body;
    }


}
