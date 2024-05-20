package org.example;
import java.util.Random;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Treap treap = new Treap(1);
        Random rand = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            int ind = rand.nextInt(array.length);
            int value = array[ind];
            treap.find(value);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения поиска:" + (endTime-startTime) + "мс");

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            treap.Add(array[i]);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Время выполнения добавления:" + (endTime1-startTime1) + "мс");

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            treap.Remove(array[rand.nextInt(array.length)]);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("Время выполнения удаления:" + (endTime2-startTime2) + "мс");
    }

}