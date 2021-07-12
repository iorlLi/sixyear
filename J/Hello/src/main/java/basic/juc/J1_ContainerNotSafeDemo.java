package basic.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * List 线程不安全解决方法
 * 1. 故障现象
 * java.util.ConcurrentModificationException
 * 2. 导致原因
 *
 * 3. 解决方案
 * 3.1 new Vector   同步方法
 * 3.2 Collections.synchronizedList(new ArrayList<>());  同步代码快
 * 3.3 CopyOnWriteArrayList  lock.lock(); + 数组复制扩容
 *
 * <p>
 * 4. 优化建议：避免再发生
 */
public class J1_ContainerNotSafeDemo {
    public static void main(String[] args) {
        //Map
        Map<String, String> map = new ConcurrentHashMap<>();
        //
        listNoteSafe();
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                //  synchronized (ContainerNotSafeDemo.class) {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
                // }
            }, String.valueOf(i)).start();
        }
    }

    private static void listNoteSafe() {
//                List<String> list = new ArrayList<>();
         List<String> list  = new Vector<String>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                //  synchronized (ContainerNotSafeDemo.class) {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
                // }
            }, String.valueOf(i)).start();
        }
    }
}
