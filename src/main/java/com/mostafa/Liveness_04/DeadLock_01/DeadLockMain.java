package com.mostafa.Liveness_04.DeadLock_01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling_01.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class DeadLockMain {
    public static void main(String[] args) throws Exception {
        // Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
        // Deadlock occurs when multiple threads need the same locks but obtain them in different order.
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        new Philosopher("Mostafa", chopstickA, chopstickB).start();
        new Philosopher("Golam", chopstickB, chopstickC).start();

        // First thread used A and B chopstick. Second thread used B and C chopstick.
        // But third thread used C and A thread which can make a deadlock scenario.
//        new Philosopher("Shohag", chopstickC, chopstickA).start();

        // By reordering C and A to A and C will solve deadlock issue.
        new Philosopher("Shohag", chopstickA, chopstickC).start();
    }
}
