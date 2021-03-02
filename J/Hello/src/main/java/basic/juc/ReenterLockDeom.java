package basic.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDeom {
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
