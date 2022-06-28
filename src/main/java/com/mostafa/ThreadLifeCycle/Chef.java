package com.mostafa.ThreadLifeCycle;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.ThreadLifeCycle.Chef.java: JavaParallelProgramming
 * @CreationDate 6/28/2022 12:19 PM
 */
public class Chef extends Thread{
    @Override
    public void run() {
        System.out.println("Helper Chef started & waiting for sausage to thaw...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Helper Chef is done cutting sausage.");
    }
}
