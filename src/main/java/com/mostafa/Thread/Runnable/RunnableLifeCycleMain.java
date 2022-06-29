package com.mostafa.Thread.Runnable;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ThreadLifeCycle.java: JavaParallelProgramming
 * @CreationDate 6/28/2022 12:18 PM
 */
public class RunnableLifeCycleMain {
    public static void main(String[] args) throws Exception{
        System.out.println("Main Chef started & requesting Helper Chef's help.");

        //Initialize helper thread
        Thread helper = new Thread(new Chef());
        System.out.println("Helper Chef state: " + helper.getState());

        System.out.println("Main Chef tells Helper Chef to start.");
        //Helper thread start
        helper.start();
        System.out.println("Helper Chef state: " + helper.getState());

        System.out.println("Main Chef continues cooking soup.");
        //Main thread going to sleep
        Thread.sleep(500);
        System.out.println("Helper Chef state: " + helper.getState());

        System.out.println("Main Chef patiently waits for Helper Chef to finish and join...");
        helper.join();
        System.out.println("Helper Chef state: " + helper.getState());

        System.out.println("Main Chef and Helper Chef are both done!");
    }
}
