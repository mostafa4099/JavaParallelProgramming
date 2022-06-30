package com.mostafa.Locks.Try;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class TryLockMain {
    public static void main(String[] args) throws Exception {
        Thread shopper1 = new Shopper("Mostafa");
        Thread shopper2 = new Shopper("Golam");
        long start = System.currentTimeMillis();
        shopper1.start();
        shopper2.start();
        shopper1.join();
        shopper2.join();
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (float)(finish - start)/1000 + " seconds");
    }
}
