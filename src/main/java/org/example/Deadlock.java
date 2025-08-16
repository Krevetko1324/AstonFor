package org.example;

public class Deadlock {
    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                synchronized (b) {
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                synchronized (a) {
                }
            }
        }).start();
    }
}