package basic.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> ref = new AtomicReference<>(100);
    //初始值 版本号
    static AtomicStampedReference<Integer> refs = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        //ABA产生
        new Thread(() -> {
            ref.compareAndSet(100, 101);
            ref.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ref.compareAndSet(100, 2021);
            System.out.println(ref.get());
        }, "t2").start();


        // 在做销户结息时候，版本号是保存在数据库中的
        try {
            System.out.println("ABA解决方案");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            int stamp = refs.getStamp();
            System.out.println(Thread.currentThread().getName() + "  第一次版本号" + stamp);
            //保证t3和t4拿到相同的版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            refs.compareAndSet(100, 101, refs.getStamp(), refs.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "  第二次版本号" + refs.getStamp());
            refs.compareAndSet(101, 100, refs.getStamp(), refs.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "  第3次版本号" + refs.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = refs.getStamp();
            System.out.println(Thread.currentThread().getName() + " 第一次版本号 " + stamp);
            //保证 t3完成操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = refs.compareAndSet(100, 2021, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + " 修改结果" + result);
            System.out.println(refs.getStamp() + " " + refs.getReference());

        }, "t4").start();
    }
}
