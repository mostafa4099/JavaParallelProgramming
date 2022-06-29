package com.mostafa.Mutex.DataRace;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    static int productCtr = 0;

    @Override
    public void run() {
//        for (int i=0; i<10; i++)
        for (int i=0; i<10000; i++)
            productCtr++;
    }
}
