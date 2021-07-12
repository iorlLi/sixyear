package basic.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 加到指定数生效
 */
public class J6_CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("达到计数器的值之后，执行此runnable");
        });
        for (int i = 0; i < 7; i++) {
            final int fi = i;
            System.out.println("run方法外当前活跃线程数" + Thread.activeCount());
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号线程，收集" + fi + "到龙珠");
                try {
                    System.out.println("当前活跃线程数" + Thread.activeCount());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("await之后线程数" + Thread.activeCount());
    }
}
