package net.vrakin;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * Multithreading
 *
 */
public class App 
{

    public static final int ELEMENT_COUNT = 2_000_000;

    public static void main(String[] args )
    {
        for (int i = 2; i <= 100; i++) {
            Thread thread = new Thread(new FactorialThread(i));
            thread.start();
        }

        runMultiTheadSum();
    }

    private static void runMultiTheadSum() {
        int[] elements = new int[ELEMENT_COUNT];

        Random random = new Random();
        Arrays.fill(elements, random.nextInt(2_000_000));

        BigInteger sum = BigInteger.ZERO;

        long tstart0 = System.currentTimeMillis();
        for (int i = 0; i < elements.length; i++) {
            sum = sum.add(BigInteger.valueOf(elements[i]));
        }
        long tend0 = System.currentTimeMillis();
        System.out.println((tend0 - tstart0) + " ms" + " - Simple sum");

        long tstart1 = System.currentTimeMillis();
        MultiThreadSum.sum(elements, 5);
        long tend1 = System.currentTimeMillis();
        System.out.println((tend1 - tstart1) + " ms" + " - MultiThread sum");
    }
}
