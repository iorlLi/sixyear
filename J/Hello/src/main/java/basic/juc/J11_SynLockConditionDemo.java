package basic.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class J11_SynLockConditionDemo {
    public static void main(String[] args) {
        ShareResource s = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                s.prinf5();
            }
        }, "aaa").start();
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                s.prinf10();
            }
        }, "bbb").start();
        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                s.prinf15();
            }
        }, "ccc").start();
    }
}

class ShareResource {

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    private int flag = 1;//a-1 b-2 c-3


    public void print() {
        lock.lock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void prinf5() {
        lock.lock();
        try {
            //判断
            while (flag != 1) {
                c1.await();
            }
            //do
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //signal
            flag = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void prinf10() {
        lock.lock();
        try {
            //判断
            while (flag != 2) {
                c2.await();
            }
            //do
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //signal
            flag = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void prinf15() {
        lock.lock();
        try {
            //判断
            while (flag != 3) {
                c3.await();
            }
            //do
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //signal
            flag = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}