package com.TravelingAroundMoscow;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file_name = "input.txt";
        try {
            Scanner scanner = new Scanner(new File(file_name));
            double a1 = scanner.nextInt();
            double b1 = scanner.nextInt();
            double a2 = scanner.nextInt();
            double b2 = scanner.nextInt();
            double angle1 = Math.atan2(b1, a1);
            double angle2 = Math.atan2(b2, a2);

            double f = Math.sqrt(a1 * a1 + b1 * b1) + Math.sqrt(a2 * a2 + b2 * b2);
            double s1 = Math.abs(Math.sqrt(a1 * a1 + b1 * b1) - Math.sqrt(a2 * a2 + b2 * b2));
            double s2 = Math.min(Math.sqrt(a1 * a1 + b1 * b1), Math.sqrt(a2 * a2 + b2 * b2));
            double dst = s1 + s2 * Math.abs(angle2 - angle1);
            System.out.println(Math.min(dst, f));
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


