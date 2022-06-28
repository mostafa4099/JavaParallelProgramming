package com.mostafa.Thread.ExecutionScheduling;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File ExecutionScheduling.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class ExecutionScheduling {
    public static void main(String[] args) throws Exception {
        //First thread initialize
        VegetableChopper first = new VegetableChopper("First");
        System.out.println(first.getName()+" thread status is "+first.getState());

        //Second thread initialize
        VegetableChopper second = new VegetableChopper("Second");
        System.out.println(second.getName()+" thread status is "+second.getState());

        //First thread start
        first.start();
        System.out.println(first.getName()+" thread status is "+first.getState());

        //Second thread start
        second.start();
        System.out.println(second.getName()+" thread status is "+second.getState());

        System.out.println(Thread.currentThread().getName()+" thread status is "+Thread.currentThread().getState());
        // Sleep current or root or main() thread for 1000 millisecond.
        // In this scenario main() method will go sleep and not execute next code block for 1000 millisecond.
        // But first and second thread will run their execution parallelly.
//        Thread.sleep(1000);
        Thread.sleep(5);
        System.out.println(Thread.currentThread().getName()+" thread status is "+Thread.currentThread().getState());

        VegetableChopper.chopping = false;

        // Join first thread with main thread
        // After joining first thread it will be terminated. Because of VegetableChopper.chopping = false
        first.join();
        System.out.println(first.getName()+" thread status is "+first.getState());

        // Join second thread with main thread
        // After joining second thread it will be terminated. Because of VegetableChopper.chopping = false
        second.join();
        System.out.println(second.getName()+" thread status is "+second.getState());

        System.out.format("Mostafa chopped %d vegetables.\n", first.vegetable_ctr);
        System.out.format("Golam chopped %d vegetables.\n", second.vegetable_ctr);
    }
}
