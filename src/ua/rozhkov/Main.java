package ua.rozhkov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        double fibonachi = Math.round((Math.pow(phi, n)) / Math.sqrt(5));

        System.out.print("Input n: ");
        String input = new Scanner(System.in).nextLine();
        int n = -1;
        String divider = "";
        if (input.contains(" ")) {
            divider = " ";
        } else if (input.contains(",")) {
            divider = ",";
        } else if (input.contains(", ")) {
            divider = ", ";
        } else {
            try {
                n = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Input is not a number!");
                return;
            }
        }
        if (!divider.equals("")) {
            String[] range = input.split(divider);
            Main.fibonachiRange(Double.parseDouble(range[0]), Double.parseDouble(range[1]));
        } else {
            //Main.fibonachiN(n);
            Main.fibonachiLen(n);
        }

    }

    static void fibonachiN(int n) {
        if (n <= 100) {
            for (int i = 1; i <= n; i++) {
                if (n <= 1) {
                    System.out.print("1");
                } else {
                    double fibonachi = Main.fibonachi(i);
                    System.out.printf("%.0f", fibonachi);
                    System.out.print(" ");
                }
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
        } else {
            System.out.println("Too much numbers!");
        }
    }

    static void fibonachiRange(double min, double max) {
        double fibonachi = 0;
        int i = 0;
        while (fibonachi <= max) {
            fibonachi = Main.fibonachi(i);
            if (fibonachi >= min) {
                System.out.printf("%.0f", fibonachi);
                System.out.print(" ");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
            i++;
        }
    }

    static void fibonachiLen(int length) {
        double fibonachi = 0;
        int i = 0;
        while (String.valueOf(Math.round(fibonachi)).length() <= length) {
            fibonachi = Main.fibonachi(i);
            if (String.valueOf(Math.round(fibonachi)).length() == length) {
                System.out.printf("%.0f", fibonachi);
                System.out.print(" ");
            }
            i++;
        }
    }

    static double fibonachi(int n) {

        return Math.round((Math.pow((1 + Math.sqrt(5)) / 2, n)) / Math.sqrt(5));
    }
}
