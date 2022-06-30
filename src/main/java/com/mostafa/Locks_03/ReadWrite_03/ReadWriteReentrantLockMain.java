package com.mostafa.Locks_03.ReadWrite_03;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling_01.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class ReadWriteReentrantLockMain {
    public static void main(String[] args) throws Exception {
        // create ten reader threads
        for (int i=0; i<10; i++)
            new CalendarUser("Reader-"+i).start();

        // ...but only two writer threads
        for (int i=0; i<2; i++)
            new CalendarUser("Writer-"+i).start();
    }
}
