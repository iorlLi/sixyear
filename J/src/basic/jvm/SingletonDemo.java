package basic.jvm;

public class SingletonDemo {
    static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println("执行构造器");
    }

    //懒汉单例
    public static SingletonDemo getInstance1() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    //DCL double check lock 双端检查：加锁前后
    public static SingletonDemo getInstance2() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //SignletonDemo.getInstance1();
                SingletonDemo.getInstance2();
            }, String.valueOf(i)).start();
        }

    }

}
