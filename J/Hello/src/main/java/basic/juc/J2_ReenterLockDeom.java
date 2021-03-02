package basic.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（递归锁）：线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 * https://zhuanlan.zhihu.com/p/71156910
 *
 * 可重入锁的字面意思是“可以重新进入的锁”，即允许同一个线程多次获取同一把锁。
 * 比如一个递归函数里有加锁操作，递归过程中这个锁如果不会阻塞自己，那么这个锁
 * 就是可重入锁（因为这个原因可重入锁也叫做递归锁）。
 */
public class J2_ReenterLockDeom {
    public static void main(String[] args) {
        Phone phone = new Phone();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
//                phone.sendMsg();
                phone.sendMsg2();
            }, "t" + String.valueOf(i)).start();
        }
    }
}

class Phone {
    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "\t sendMsg");
        sendTex();
    }

    public synchronized void sendTex() {
        System.out.println(Thread.currentThread().getName() + "\t ********sendText");
    }

    Lock lock = new ReentrantLock();

    public void sendMsg2() {
        lock.lock();
        /*
        lock()多了，运行时卡死，因为还有锁未释放
         */
        lock.lock();//加、解锁的数量要匹配
        try {
            System.out.println(Thread.currentThread().getName() + "\t sendMsg2");
            sendTex2();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void sendTex2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ********sendText2");
        } finally {
            lock.unlock();
            /*
            unlock()多了运行时异常
            IllegalMonitorStateException
             */
            //lock.unlock();
        }
    }


}
