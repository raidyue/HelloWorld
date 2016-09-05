package com.raidyue.JavaConcurrencyInPractice;

/**
 * Created by yuexiaodong on 16/9/4.
 */
public class Programm_3_2 {

    private static boolean ready;
    private static int     number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {

            new ReaderThread().start();
            number = 42;
            ready = true;
        }
    }

}
