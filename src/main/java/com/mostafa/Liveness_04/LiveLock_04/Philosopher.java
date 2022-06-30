package com.mostafa.Liveness_04.LiveLock_04;

import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Philosopher extends Thread {
    // A thread often acts in response to the action of another thread.
    // If the other thread's action is also a response to the action of another thread, then livelock may result.
    // As with deadlock, livelocked threads are unable to make further progress.
    // However, the threads are not blocked — they are simply too busy responding to each other to resume work.
    private static Lock firstChopstick, secondChopstick;
    private Random rps = new Random();
    private static int sushiCount = 500000;

    public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    @Override
    public void run() {
        int sushiEaten = 0;
        while (sushiCount > 0) { // eat sushi until it's all gone
            // pick up chopsticks
            firstChopstick.lock();

            //making livelock.
            if (!secondChopstick.tryLock()) {
                System.out.println(this.getName() + " released their first chopstick.");
                firstChopstick.unlock();

                //Randomness solve the livelock problem
                try {
                    Thread.sleep(rps.nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    // take a piece of sushi
                    if (sushiCount > 0) {
                        sushiCount--;
                        sushiEaten++;
                        System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                    }
                } finally {
                    // put down chopsticks
                    secondChopstick.unlock();
                    firstChopstick.unlock();
                }
            }
        }
    }
}
