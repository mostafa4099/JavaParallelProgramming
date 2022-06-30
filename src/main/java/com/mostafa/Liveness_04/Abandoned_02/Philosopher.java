package com.mostafa.Liveness_04.Abandoned_02;

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
        while (sushiCount > 0) { // eat sushi until it's all gone
            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

            try {
                // take a piece of sushi
                if (sushiCount > 0) {
                    sushiCount--;
                    System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                }

                // This block will create deadlock block.
                // Because among 3 thread 1 thread will execute this block and get an error.
                // It will terminate the thread without releasing lock.
                // But other 2 thread will be in the waiting stage, and it will arise a deadlock scenario.
                // To solve this issue we need place our critical block within try block
                // and unlock block in finally block
                if (sushiCount == 10)
                    System.out.println(1 / 0);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                // put down chopsticks
                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
    }
}
