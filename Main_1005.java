package com.company;

import java.util.*;

public class Main_1005 {
    static Scanner scanner = new Scanner(System.in);
    static long result = 0;

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int[] stones = Arrays.stream(str.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = Arrays.stream(stones).sum();
        int S = sum / 2;
        getAllSums(stones, 0, n - 1, 0, S);
        System.out.println(sum - 2 * result);
    }

    static void getAllSums(int[] arr, int l, int r, int s, int limit) {
        if (l > r) {
            if (s > result)
                result = s;
            return;
        }
        if (s + arr[l] <= limit) {
            getAllSums(arr, l + 1, r, s + arr[l], limit);
        }
        getAllSums(arr, l + 1, r, s, limit);
    }
}