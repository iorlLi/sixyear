package basic.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * countDownLatch减为0之后，await放行，或者达到await的设定超时时间
 * 减完生效
 */
public class J5_CountDownLatchDemo {
    @SneakyThrows
    public static void main(String[] args) {
        int count = 6;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + " for each");
                /*try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await(6,TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + " main 线程");
    }
}
