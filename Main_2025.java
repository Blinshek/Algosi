package com.company;

import java.util.Scanner;

public class Main_2025 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = scan.nextInt(), k = scan.nextInt();
            int ost = n % k;
            if (ost != 0) {
                int t = n - ost;
                int ans = t * t / k * (k - 1) / 2;
                ans += (t - t / k) * ost + ost * (ost - 1) / 2;
                System.out.println(ans);
            } else {
                System.out.println(n * n / k * (k - 1) / 2);
            }
        }
    }
}