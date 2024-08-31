package net.vrakin;

import java.math.BigInteger;

public class FactorialThread implements Runnable{

    private final int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.printf("Факторіал числа %d - %s%n", number, result);
    }
}
