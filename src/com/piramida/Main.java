package com.piramida;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String str = scanner.nextLine();

        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();


        Main ob = new Main();
        ob.sort(arr);

        printArray(arr);
    }


    public void sort(int arr[])
    {
        int N = arr.length;


        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);


        for (int i = N - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }


    void heapify(int arr[], int N, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;


        if (r < N && arr[r] > arr[largest])
            largest = r;


        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }


    static void printArray(int arr[])
    {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}