package basic.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 队列常用操作
 */
public class J8_BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
            add():加入队列尾部，如果超过容量： java.lang.IllegalStateException: Queue full
            remove(): 获取队列头部元素，如果队列为空 java.util.NoSuchElementException
         */
        BlockingQueue<String> a = new ArrayBlockingQueue<>(3);
        boolean a1 = a.add("a");
        System.out.println(a1);
        a.add("b");
        a.add("c");
        //a.add("c");
        a.remove();
        a.remove();
        a.remove();
//        a.remove();
        /*
            offer():添加，队列满了不会抛出异常，返回false
            poll():获取，队列为空返回false
            offer("d", 3, TimeUnit.SECONDS)：超时加
            poll()
         */
        BlockingQueue<String> b = new ArrayBlockingQueue<>(3);
        boolean offer = b.offer("a");
        b.offer("b");
        b.offer("c");
        boolean offer1 = b.offer("d");
        b.offer("d", 3, TimeUnit.SECONDS);
        System.out.println(offer);
        System.out.println("offer: " + offer);
        System.out.println("offer1: " + offer1);
        String poll = b.poll();
        b.poll();
        b.poll();
        String poll1 = b.poll();
        b.poll(3, TimeUnit.SECONDS);
        System.out.println("poll: " + poll);
        System.out.println("poll1: " + poll1);
        /*
            put():阻塞加
            take():阻塞获取
         */
        BlockingQueue<String> c = new ArrayBlockingQueue<>(3);
        c.put("a");
        c.take();
    }
}
