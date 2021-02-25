package basic.juc;

/**
 * 理论上，操作应该由资源类提供
 * 如资源类是空调，那么制冷/制热是空调的方法
 * 线程只是去调用这个方法而不是直接改变空调的模式
 * 线程   操作   资源类
 */
public class StartDemo1 {
    static int count = 30000, sale = count + 100;
    public static void main(String[] args) {
        System.out.println("许愿2021年春节票");
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < sale; i++) {
                    ticket.saleTiket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < sale; i++) {
                    ticket.saleTiket();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < sale; i++) {
                    ticket.saleTiket();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < sale; i++) {
                ticket.saleTiket();
            }
        }, "D").start();
    }
}


class Ticket {
    private static  int number = 30000;

    public synchronized void saleTiket() {
        if (number > 0) {
            System.out.println("操作员:" + Thread.currentThread().getName()
                    + "，卖出第" + (number--) + "张票，剩余" + number);
        }
    }
}