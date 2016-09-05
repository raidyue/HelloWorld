package com.raidyue.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 16-3-14
 */
public class TaskTest {
    static int                         index;
    static ScheduledThreadPoolExecutor executor;

    public static void main(String[] args) {
        executor = new ScheduledThreadPoolExecutor(1);
        TaskClass task = new TaskClass();
        executor.scheduleWithFixedDelay(task, 1, 5, TimeUnit.SECONDS);
    }

    private static String getTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return format.format(date);
    }

    static class TaskClass implements Runnable {

        @Override
        public void run() {
            index++;
            System.out.println("2= " + getTimes() + " " + index);
            if (index >= 10) {
                executor.shutdown();
                if (executor.isShutdown()) {
                    System.out.println("停止了？？？？");
                }
//                try {
//                    throw new Exception("...");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

}
