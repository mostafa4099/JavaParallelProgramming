package com.mostafa.Locks.Try;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    private int itemsToAdd = 0; // items this shopper is waiting to add
    private static int itemsOnNotepad = 0; // total items on shared notepad
    private static Lock pencil = new ReentrantLock();

    public Shopper(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (itemsOnNotepad <= 5){
//            if (itemsToAdd > 0) { // add item(s) to shared notepad
//                try {
//                    // Reentrant lock help to concurrently complete task to all thread.
//                    // If a thread block the resource it passes another thread in waiting stage.
//                    // So it takes more time.
//                    pencil.lock();
//                    itemsOnNotepad += itemsToAdd;
//                    System.out.println(this.getName() + " added " + itemsToAdd + " item(s) to notepad.");
//                    itemsToAdd = 0;
//                    Thread.sleep(300); // time spent writing
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    pencil.unlock();
//                }
//            } else { // look for other things to buy
//                try {
//                    Thread.sleep(100); // time spent searching
//                    itemsToAdd++;
//                    System.out.println(this.getName() + " found something to buy.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            // Reentrant lock passes other threads in waiting stage. So it takes more time.
            // But try lock will not pass other threads in waiting stage.
            // It returns true if lock is acquired otherwise false.
            // So that other threads can complete their others task. As result, it takes less time.
            if ((itemsToAdd > 0) && pencil.tryLock()) { // add item(s) to shared notepad
                try {

                    itemsOnNotepad += itemsToAdd;
                    System.out.println(this.getName() + " added " + itemsToAdd + " item(s) to notepad.");
                    itemsToAdd = 0;
                    Thread.sleep(300); // time spent writing
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    pencil.unlock();
                }
            } else { // look for other things to buy
                try {
                    Thread.sleep(100); // time spent searching
                    itemsToAdd++;
                    System.out.println(this.getName() + " found something to buy.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
