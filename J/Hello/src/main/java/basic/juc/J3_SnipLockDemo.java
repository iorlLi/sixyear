package basic.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public class J3_SnipLockDemo {
    public static void main(String[] args) {
        J3_SnipLockDemo demo = new J3_SnipLockDemo();
        new Thread(() -> {
            demo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.unLock();
        }, "a").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            demo.lock();
            demo.unLock();
        }, "bb").start();
    }

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " comming ....");
        while (!atomicReference.compareAndSet(null, thread)) {

            System.out.println(Thread.currentThread().getName() + " 在自旋");
        }
    }

    private void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "  unlock...");

    }

}
