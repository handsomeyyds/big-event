package org.example;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet() {
        // 提供一个ThreadLocal对象
        ThreadLocal t1 = new ThreadLocal();
        new Thread(() -> {
            t1.set("z1");
            System.out.println(Thread.currentThread().getName() + ": " + t1.get());
            System.out.println(Thread.currentThread().getName() + ": " + t1.get());
            System.out.println(Thread.currentThread().getName() + ": " + t1.get());
        }, "blue").start();

        new Thread(() -> {
            t1.set("qqqq1");
            System.out.println(Thread.currentThread().getName() + ": " + t1.get());
            System.out.println(Thread.currentThread().getName() + ": " + t1.get());
            System.out.println(Thread.currentThread().getName() + ": " + t1.get());
        }, "green").start();
    }
}
