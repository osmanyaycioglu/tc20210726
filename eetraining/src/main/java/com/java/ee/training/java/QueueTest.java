package com.java.ee.training.java;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {

    private final BlockingQueue<String> strQueue = new ArrayBlockingQueue<>(1000);

    public static void main(final String[] args) throws Exception {
        QueueTest queueTestLoc = new QueueTest();
        queueTestLoc.strQueue.add("test");
        for (int iLoc = 0; iLoc < 5; iLoc++) {
            MyThread myThreadLoc = new MyThread(queueTestLoc,
                                                iLoc);
            myThreadLoc.start();
        }
        Scanner scannerLoc = new Scanner(System.in);
        while (true) {
            System.out.println("bir string girin : ");
            String nextLineLoc = scannerLoc.nextLine();
            queueTestLoc.strQueue.add(nextLineLoc);
        }
    }

    public static class MyThread extends Thread {

        private final QueueTest queueTest;
        private final int       index;

        public MyThread(final QueueTest queueTestParam,
                        final int index) {
            super();
            this.setName("QueueReader-" + index);
            this.queueTest = queueTestParam;
            this.index = index;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String takeLoc = this.queueTest.strQueue.take();
                    System.out.println(this.index + " aldım : " + takeLoc);
                } catch (Exception eLoc) {
                }

            }
        }
    }
}
