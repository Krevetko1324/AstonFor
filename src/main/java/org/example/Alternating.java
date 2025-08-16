package org.example;

public class Alternating {
    static boolean turn = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (turn) {
                    System.out.println("1");
                    turn = false;
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (!turn) {
                    System.out.println("2");
                    turn = true;
                }
            }
        }).start();
    }
}