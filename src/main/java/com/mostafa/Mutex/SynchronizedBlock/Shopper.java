package com.mostafa.Mutex.SynchronizedBlock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    static int productCtr = 0;

    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            // like synchronized method synchronized block also used for concurrency operation.
            // if 2 thread try to access synchronized block one of them need to wait until release prev-one.
            // Within synchronized block signature we need to pass object.
            synchronized (Shopper.class) {
                productCtr++;
            }

            // Within synchronized block signature we need to pass object.
            // If we pass Shopper.class it will be Shopper class it-self.
            // But if we pass this keyword it will point to the current thread object.
            // Data race problem remain same.
//            synchronized (this) {
//                productCtr++;
//            }
        }
    }
}
