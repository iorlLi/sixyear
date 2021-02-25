package basic.jvm;

public class SignletonDemo {
    static volatile SignletonDemo instance = null;

    private SignletonDemo() {
        System.out.println("执行构造器");
    }

    //懒汉单例
    public static SignletonDemo getInstance1() {
        if (instance == null) {
            instance = new SignletonDemo();
        }
        return instance;
    }

    //DCL double check lock 双端检查：加锁前后
    public static SignletonDemo getInstance2() {
        if (instance == null) {
            synchronized (SignletonDemo.class) {
                if (instance == null) {
                    instance = new SignletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //SignletonDemo.getInstance1();
                SignletonDemo.getInstance2();
            }, String.valueOf(i)).start();
        }

    }

}
