package com.mostafa.Thread_01.ExecutionScheduling_01;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File VegetableChopper.java: JavaParallelProgramming
 * @CreationDate 6/27/2022 5:06 PM
 */
public class VegetableChopper extends Thread{
    public int vegetable_ctr = 0;
    public static boolean chopping = true;

    public VegetableChopper(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (chopping) {
            System.out.println(this.getName()+" chopped a vegetable!");
            vegetable_ctr ++;
        }
    }
}
