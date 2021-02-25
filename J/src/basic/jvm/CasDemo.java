package basic.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomatic实现：unsafe + cas
 * comparmAndSwap  比较并交换
 * unsafe类的方法为 cpu原语，自身就保证了原子性
 *
 * cas：不加锁，保证一致性
 synchronized :一致性保证，并发量下降
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(3);

        System.out.println(atomicInteger.compareAndSet(3, 111) + " "+atomicInteger);
        System.out.println(atomicInteger.compareAndSet(3, 222) + " "+atomicInteger);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();
    }

}
