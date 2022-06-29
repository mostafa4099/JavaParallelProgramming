package com.mostafa.Mutex.DataRace;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class DataRaceMain {
    public static void main(String[] args) throws Exception {
        Thread shopper1 = new Shopper();
        Thread shopper2 = new Shopper();
        shopper1.start();
        shopper2.start();

        // Shopper 1 and shopper 2 should add same number of data in product ctr (10000+10000 = 20000).
        // But both thread use same data variable productCtr that means data race arise.
        // That's why productCtr gives different result in different time.
        // May be shopper one add some data in productCtr but shopper two missed and add some data with previous one.
        // When 2 or more thread use same resource than data race will arise.
        shopper1.join();
        shopper2.join();
        System.out.println("We should buy " + Shopper.productCtr + " product.");
    }
}
