package com.mostafa.Mutex_02.SynchronizedBlock_05;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling_01.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class SynchronizedStatementMain {
    public static void main(String[] args) throws Exception {
        Thread shopper1 = new Shopper();
        Thread shopper2 = new Shopper();
        shopper1.start();
        shopper2.start();
        shopper1.join();
        shopper2.join();
        System.out.println("We should buy " + Shopper.productCtr + " product.");
    }
}
