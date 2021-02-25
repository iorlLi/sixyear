import iorl.HelloWorld;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void test1() {
        HelloWorld helloWorld = new HelloWorld();
        String s = helloWorld.sayHello();
        Assert.assertEquals("hello world !bbb", s);
    }
}
