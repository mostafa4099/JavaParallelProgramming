package com.mostafa.Locks.Reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class Shopper extends Thread{
    static int potatoCtr, garlicCtr = 0;

    // The ReentrantLock class implements the Lock interface and
    // provides synchronization to methods while accessing shared resources.
    // The code which manipulates the shared resource is surrounded by calls to lock and unlock method.
    // This gives a lock to the current working thread and
    // blocks all other threads which are trying to take a lock on the shared resource.
    // As the name says, ReentrantLock allows threads to enter into the lock on a resource more than once.
    // When the thread first enters into the lock, a hold count is set to one.
    // Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one.
    // For every unlocks request, hold count is decremented by one and
    // when hold count is 0, the resource is unlocked.
    static ReentrantLock pencil = new ReentrantLock();

    private void addGarlic() {
        pencil.lock();
        garlicCtr++;
        System.out.println("Hold count: "+pencil.getHoldCount());
        pencil.unlock();
    }

    private void addPotato() {
        pencil.lock();
        potatoCtr++;
        //create deadlock. But reentrant lock resolve the problem.
        addGarlic();
        pencil.unlock();
    }

    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            addGarlic();
            addPotato();
        }
    }
}
