package basic.thread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * * Q:线程池是什么时候创建线程的？
 * * 任务提交的时候
 * * Q:任务runnable task是先放到core到maxThread之间的线程，还是先放到队列？
 * * 先放队列,队列满并且maxthread也满了， 还有新任务，默认策略是reject
 * * Q:core到maxThread之间的线程什么时候会die?
 * * 没有任务时到超时时间，或者抛异常时。
 * * core 线程也会die的，core到maxThread之间的线程有可能会晋升到core线程区间，
 * * 异常策略：
 * * AbortPolicy：
 * * 抛出java.util.concurrent.RejectedExecutionException
 * * CallerRunsPolicy：直接执行认为的【run】方法
 * * DiscardPolicy:直接丢弃
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 2,
                0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(6), new ThreadPoolExecutor.CallerRunsPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(6);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> {
            System.out.println("这也是同步器");
        });
        for (int i = 0; i < 6; i++) {
            threadPool.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + LocalDate.now());
//                try {
//               //     cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
                countDownLatch.countDown();
            }));
        }
        countDownLatch.await();
        threadPool.shutdown();

        System.out.println("===========================");
        ExecutorService threadPool3 = new ThreadPoolExecutor(2, 2,
                5, TimeUnit.MINUTES, new LinkedBlockingQueue<>(), new MyThredaFactory(), new MyRejectedExecutionHandler());

        for (int i = 0; i < 2; i++) {
            threadPool3.execute(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + LocalDateTime.now());
            });
        }
        threadPool3.shutdown();
    }

    public static class MyThredaFactory implements ThreadFactory {
        AtomicInteger c = new AtomicInteger(9);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(MyThredaFactory.class.getSimpleName() + c.addAndGet(1));
            return t;
        }
    }

    private static class MyRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 记录异常
            // 报警处理等
            System.out.println("error.............");
        }
    }
}