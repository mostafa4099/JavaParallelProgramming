package com.mostafa.Locks.ReadWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class CalendarUser extends Thread{
    private static final String[] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static int today = 0;

    // Each reader and writer thread need to access concurrently.
    // Reader thread need to wait until writer thread execution it's task before read.
//    private static ReentrantLock marker = new ReentrantLock();

    //Reader thread continue it's reading when writer thread execute it's writing.
    private static ReentrantReadWriteLock marker = new ReentrantReadWriteLock();
    private static Lock writeLock = marker.writeLock();
    private static Lock readLock = marker.readLock();


    public CalendarUser(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (today < WEEKDAYS.length-1){
            if (this.getName().contains("Writer")) { // update the shared calendar
//                marker.lock();
                writeLock.lock();
                try {
                    today = (today+1) % 7;
                    System.out.println(this.getName() + " updated date to " + WEEKDAYS[today]);
                } catch (Exception e)
                {e.printStackTrace(); }
                {
//                    marker.unlock();
                    writeLock.unlock();
                }
            } else { // Reader - check to see what today is
//                marker.lock();
                readLock.lock();
                try {
//                    System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today]);
                    System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today]+". Total Reader: "+marker.getReadLockCount());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    marker.unlock();
                    readLock.unlock();
                }
            }
        }
    }
}
