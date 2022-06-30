package com.mostafa.Mutex_02.AtomicVariable_03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    static AtomicInteger productCtr = new AtomicInteger(0);

    @Override
    public void run() {
//        for (int i=0; i<10; i++)
        for (int i=0; i<10000; i++)
            // if it is simple operation like increment a counter, can use Atomic Variable instead of lock.
            // Atomic variable provide concurrency like lock method.
            productCtr.incrementAndGet();
    }
}
