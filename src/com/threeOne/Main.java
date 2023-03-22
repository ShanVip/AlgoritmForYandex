package com.threeOne;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] arr = new int[36];
        arr[0] = 0;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 7;

        int i = 4;

        while (i<=num){
            arr[i] =( arr[i-1]+arr[i-2]+arr[i-3]);
            i+=1;
        }
        System.out.println(arr[num]);
    }
}
