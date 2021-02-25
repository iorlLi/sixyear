package designpattern.create.abstractfactory;

public class MainTest {
    public static void main(String[] args) {
        //获取工厂类
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        System.out.println(shapeFactory.getClass().getName());
        //通过工厂类获取对象
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("red");
        red.fill();
    }
}
