package iorl;

import org.apache.commons.lang3.StringUtils;

public class HelloWorld {

    public static void main(String[] args) {
        String s = new HelloWorld().sayHello();
        System.out.println(s);

    }
    public String sayHello(){
        return "hello world !" + StringUtils.defaultIfBlank("", "bbb");
    }
}
