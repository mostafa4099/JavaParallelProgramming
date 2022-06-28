package com.mostafa.MutualExclusion.SynchronizedMethod;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    static int productCtr = 0;

    // synchronized method used for concurrency operation.
    // if 2 thread try to access synchronized method one of them need to wait until release prev-one.
    private static synchronized void addProduct() {
        productCtr++;
    }

    // non-static synchronized method not solve data race problem.
    // because 2 thread treat the synchronized method as their object method instead of Shapper class method.
//    private synchronized void addProduct() {
//        productCtr++;
//    }

    @Override
    public void run() {
        for (int i=0; i<10000; i++)
            addProduct();
    }
}
