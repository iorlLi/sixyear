package basic.juc;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 容量只有1的队列，如果队列中有元素，则阻塞
 */
public class J9_SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> s = new SynchronousQueue<>();
        new Thread(() -> {
            try {

               /* System.out.println(Thread.currentThread().getName() + "\t加入元素" + 2);
                s.put(String.valueOf(2));
                System.out.println(Thread.currentThread().getName() + "\t加入元素" + 3);
                s.put(String.valueOf(3));*/
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t加入元素" + i);
                    s.put(String.valueOf(i));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }, "aaa").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t取出元素" + s.poll());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t取出元素" + s.poll());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t取出元素" + s.poll());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "bbb").start();
    }
}
