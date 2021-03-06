package com.mostafa.Thread_01.DaemonThread_04;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class KitchenCleaner extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Cleaner cleaned the kitchen.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
