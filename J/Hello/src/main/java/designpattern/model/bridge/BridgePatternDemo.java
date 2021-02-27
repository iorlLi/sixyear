package designpattern.model.bridge;

/**
 * 只定义行为时候使用接口比较好
 * 如果有行为和属性传递，则继承，如@ode{DrawAPI}
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

}
