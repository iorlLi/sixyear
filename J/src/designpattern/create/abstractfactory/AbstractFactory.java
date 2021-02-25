package designpattern.create.abstractfactory;

/**
 * 为了统一factoryProducer返回值，故增加了抽象工厂层
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
