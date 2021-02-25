package sc.hystrixcommand;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class MyHystrixcommand extends HystrixCommand<String > {
    private RestTemplate restTemplate;

    public MyHystrixcommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);
    }

    @Override
    protected String getFallback(){
        //异常信息获取
        Throwable executionException = super.getExecutionException();
        System.out.println(executionException.getStackTrace());

        return "MyHystrixcommand getFallback";
    }

}
