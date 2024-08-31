package net.vrakin;

import java.math.BigInteger;

public class Adder implements Runnable {

    private BigInteger[] element;
    private BigInteger[] sums;
    private int numberThread;
    private int start;
    private int end;
    private Thread thread;

    public Adder(BigInteger[] element, BigInteger[] sums, int numberThread, int start, int end) {
        this.element = element;
        this.sums = sums;
        this.numberThread = numberThread;
        this.start = start;
        this.end = end;
        this.thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        BigInteger sum = BigInteger.ZERO;
        for (int i = start; i < end; i++) {
            sum = sum.add(element[i]);
        }
        sums[numberThread] = sum;
    }
}
