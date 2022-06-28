package com.mostafa.MutualExclusion.MutualExclusion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    static int productCtr = 0;
    static Lock locker = new ReentrantLock();

    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            // lock method lock the block for current thread.
            // So, another thread unable to execute the block before unlock the block by current thread.
            locker.lock();
            productCtr++;
            System.out.println(Thread.currentThread().getName()+" is thinking!");
            // unlock method release the block to execute by others thread.
            locker.unlock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
