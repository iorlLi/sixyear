package designpattern.create.singletonpattern;

public class Single {
    private static Single single1 = new Single();
    private static Single single2;

    private Single() {
    }

    //饿汉
    public static Single getInstance1() {
        return single1;
    }

    //双检锁/双重校验锁（DCL，即 double-checked locking）
    public static Single getInstance2() {
        if (single2 == null) {
            synchronized (Single.class) {
                if (single2 == null) {
                    single2 = new Single();
                }
            }
        }
        return single2;
    }
}
