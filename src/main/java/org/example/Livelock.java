package org.example;

public class Livelock {
    static boolean busy = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (busy) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                busy = !busy;
            }
        }).start();

        new Thread(() -> {
            while (!busy) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                busy = !busy;
            }
        }).start();
    }
}