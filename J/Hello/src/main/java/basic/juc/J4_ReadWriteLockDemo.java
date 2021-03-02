package basic.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁其实还是一种锁，是给一段临界区代码加锁，但是此加锁是在进行写操作的时候才
 * 会互斥，而在进行读的时候是可以共享的进行访问临界区的
 * ps：读写锁本质上是一种自旋锁
 * 读：可以同时进行
 * 写：独占+原子性
 */
public class J4_ReadWriteLockDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 10; i++) {
            String finalI = String.valueOf(i);
            new Thread(() -> {
                //cache.put(finalI, finalI);//不保证同步
                cache.put2(finalI, finalI);
            }, String.valueOf("p" + i)).start();
        }
        for (int i = 0; i < 10; i++) {
            String finalI = String.valueOf(i);
            new Thread(() -> {
                //cache.get(finalI);//不保证同步
                cache.get2(finalI);
            }, String.valueOf("g" + i)).start();
        }
    }
}

class Cache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "\t 写入开始" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "\t 读取开始");
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成" + value);
    }

    public void put2(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get2(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 读取开始");
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成" + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

