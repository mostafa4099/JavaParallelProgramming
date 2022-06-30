package com.mostafa.Liveness_04.Abandoned_02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling_01.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class AbandonedMain {
    public static void main(String[] args) throws Exception {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        new Philosopher("Mostafa", chopstickA, chopstickB).start();
        new Philosopher("Golam", chopstickB, chopstickC).start();
        new Philosopher("Shohag", chopstickA, chopstickC).start();
    }
}
