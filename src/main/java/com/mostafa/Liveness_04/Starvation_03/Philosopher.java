package com.mostafa.Liveness_04.Starvation_03;

import java.util.concurrent.locks.Lock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Philosopher extends Thread {
    private static Lock firstChopstick, secondChopstick;
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
            secondChopstick.lock();

            try {
                // take a piece of sushi
                if (sushiCount > 0) {
                    sushiCount--;
                    sushiEaten++;
                    System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                }
            }  finally {
                // put down chopsticks
                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
        // All threads didn't acquire same number of sushi.
        System.out.println(this.getName() + " took " + sushiEaten);
    }
}
