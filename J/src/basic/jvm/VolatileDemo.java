package basic.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volidate 保证了 可见性、不保证原子性，禁止指令重排序
 * jmm:java内存模式 需要 保证 可见性、原子性，禁止指令重排
 * *ate 为轻量级同步机制
 * *  * 使用 volidate + aotomic* 来保证原子性
 * * volid
 */

class Data {
    volatile  int num = 0;
    AtomicInteger ait = new AtomicInteger(0);

    public void add1() {
        num = 60;
    }
    public void add3() {
        num ++;
    }

//    AtomicInteger ait =  new AtomicInteger(0);
    public  void add2(){
        ait.getAndIncrement();
    }
}

public class VolatileDemo {


    public static void main(String[] args) {
        canAotomic();
        //canLook();
    }

    /**
     * 不保证原子性，需要使用原子类来实现
     */
    private static void canAotomic() {
        Data data1 = new Data();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data1.add2();
                    data1.add3();
                }
            }).start();
        }

        //等待多线程执行完毕
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "  " + data1.ait);
        System.out.println(Thread.currentThread().getName() + "  " + data1.num);
    }


    /**
     * 变量不加volatile不保证可见性
     */
    private static void canLook() {
        Data data1 = new Data();
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "  " + data1.num);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data1.add1();
                System.out.println(Thread.currentThread().getName() + "  " + data1.num);
            }, String.valueOf(i)).start();
        }
        while (data1.num == 0){

        }
        System.out.println(Thread.currentThread().getName() + "  " + data1.num);
    }
}
