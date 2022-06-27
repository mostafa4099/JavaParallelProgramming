package com.mostafa.ExecutionScheduling;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.ExecutionScheduling.ExecutionScheduling.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:11 PM
 */
public class ExecutionScheduling {
    public static void main(String[] args) throws Exception {
        VegetableChopper mostafa = new VegetableChopper("Mostafa");
        VegetableChopper golam = new VegetableChopper("Golam");

        mostafa.start();
        golam.start();
        Thread.sleep(1000);
        VegetableChopper.chopping = false;

        mostafa.join();
        golam.join();

        System.out.format("Mostafa chopped %d vegetables.\n", mostafa.vegetable_ctr);
        System.out.format("Golam chopped %d vegetables.\n", golam.vegetable_ctr);
    }
}
