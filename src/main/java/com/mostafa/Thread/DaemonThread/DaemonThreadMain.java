package com.mostafa.Thread.DaemonThread;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class DaemonThreadMain {
    public static void main(String[] args) throws Exception {
        Thread cleaner = new KitchenCleaner();
        // Daemon thread in Java is a low-priority thread
        // that runs in the background to perform tasks such as garbage collection.
        // Daemon thread in Java is also a service provider thread that provides services to the user thread.
        // When all the user threads die, JVM terminates this thread automatically.
        // To make a thread as daemon thread need to set attribute daemon is true
        cleaner.setDaemon(true);
        cleaner.start();

        System.out.println("Main Chef is cooking...");
        Thread.sleep(600);
        System.out.println("Main Chef is cooking...");
        Thread.sleep(600);
        System.out.println("Main Chef is cooking...");
        Thread.sleep(600);
        System.out.println("Main Chef is done!");
    }
}
