package com.mostafa.Thread_01.Runnable_03;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File Chef.java: JavaParallelProgramming
 * @CreationDate 6/28/2022 12:19 PM
 */
public class Chef implements Runnable{
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
