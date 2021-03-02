package ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * 队列转换栈
 * 队列先进先出，栈先进后厨
 * 因此，创建两个队列
 * 队列 s, 队列 n
 * 数据来了。。。
 * 增加：
 */
public class QueueToStack {
    Queue<Integer> q1 = new ArrayDeque();
    Queue<Integer> q2 = new ArrayDeque();


    public QueueToStack() {

    }

    public static void main(String[] args) {
        QueueToStack qt = new QueueToStack();
        qt.push(1);
        qt.push(2);
        qt.push(3);
        qt.push(4);
        System.out.println("开始pop");
        qt.pop();
        qt.pop();
        qt.pop();
        qt.pop();

    }

    /**
     * 入栈：
     * 将元素增加到非空队列的尾部
     * 线程不安全实现
     */
    public Integer push(Integer i) {
        System.out.println("入栈push ：" + i);
        //第一次新增
        if (q1.size() == 0 && q2.size() == 0) {
            q1.offer(i);
            System.out.println("现在的栈是:");
            prinfStack(q1);
            return i;
        }
        if (q1.size() != 0) {
            q1.offer(i);
            prinfStack(q1);
        }
        if (q2.size() != 0) {
            q2.offer(i);
            prinfStack(q2);
        }

        return i;
    }

    private void prinfStack(Iterable<Integer> q1) {
        System.out.print("现在的栈是: ");
        Iterator<Integer> iterator = q1.iterator();
        ArrayList<Integer> list = new ArrayList<>();

        if(!iterator.hasNext()){
            System.out.print("empty stack....");
            return;
        }
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print("[");
            System.out.print(list.get(i) + " ");
            System.out.print("]");
        }
        System.out.println();
    }

    /**
     * 取出栈顶元素并移除：
     * 对应就是队列的最后一个元素
     * 在两个队列中都一样
     */
    public Integer pop() {
        Integer p = null;
        if (q1.size() == 0 && q2.size() == 0) {
            System.out.println("empty Stack...");
            return p;
        }
        if (q1.size() != 0) {
            int n = q1.size();
            int n1 = q1.size();
            for (int i = 0; i < n1; i++) {
                n--;
                if (n > 0) {
                    q2.offer(q1.poll());
                    continue;
                }
                p = q1.poll();
            }
        } else if (q2.size() != 0) {
            int n = q2.size();
            int n2 = q2.size();
            for (int i = 0; i < n2; i++) {
                n--;
                if (n > 0) {
                    q1.offer(q2.poll());
                    continue;
                }
                p = q2.poll();
            }
        }
        System.out.println("出栈" + p);
        if (q1.size() > 0) {
            prinfStack(q1);
        } else {
            prinfStack(q2);
        }
        return p;
    }

}
