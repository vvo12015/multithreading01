package net.vrakin;

import java.math.BigInteger;
import java.util.Arrays;

public class MultiThreadSum {
    static void sum(int[] enteredArray, int threadCounter) {
        Adder[] adders = new Adder[threadCounter];
        BigInteger[] sums = new BigInteger[threadCounter];
        BigInteger[] array = new BigInteger[enteredArray.length];

        for (int i = 0; i < enteredArray.length; i++) {
            array[i]=BigInteger.valueOf(enteredArray[i]);
        }

        int size = array.length/threadCounter;

        for (int i = 0; i < threadCounter; i++) {
            int start = i * size;
            int end = start + size;

            if (end > array.length){
                end = array.length;
            }

            adders[i] = new Adder(array, sums, i, start, end);
        }

        try {
            for (int i = 0; i < threadCounter; i++) {
                adders[i].getThread().join();
            }
            BigInteger[] result = new BigInteger[1];
            Arrays.fill(result, BigInteger.ZERO);

            Adder resultAdder = new Adder(sums, result, 0,0, sums.length);
            resultAdder.getThread().join();
            System.out.println("Sum: " + result[0]);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
