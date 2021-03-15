package com.company;

import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main_1401 {
    static int[][] arr;
    static int n;
    static int counter = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x, y;
        boolean autoTest = false;
        if (!autoTest) {
            n = scan.nextInt();
            //x - по горизонтали
            //y - по вертикали
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
            arr = new int[(int) pow(2, n)][(int) pow(2, n)];
            getCorners(y, x);
            printSquare();
        } else {
            int testN = 4;
            for (int row = 1; row < pow(2, testN) + 1; row++) {
                for (int col = 1; col < pow(2, testN) + 1; col++) {
                    n = testN;
                    x = row - 1;
                    y = col - 1;
                    arr = new int[(int) pow(2, n)][(int) pow(2, n)];
                    getCorners(y, x);
                    System.out.println("x: " + row + ", y: " + col);
                    printSquare();
                    System.out.println();
                    counter = 1;
                }
            }
        }
    }

    public static void getCorners(int x, int y) {
        int midX = (int) pow(2, n - 1);
        int midY = (int) pow(2, n - 1);
        for (int i = 0; i < n; i++) {
            int delta = (int) pow(2, n - 2 - i);
            if (x >= midX && y >= midY) {
                //System.out.println(Corner.BottomRight);
                fillFromBottomRight(midX, midY, n - i);
                midX += delta;
                midY += delta;
            } else if (x < midX && y < midY) {
                //System.out.println(Corner.TopLeft);
                fillFromTopLeft(midX - 1, midY - 1, n - i);
                midX -= delta;
                midY -= delta;
            } else if (x >= midX) {
                //System.out.println(Corner.TopRight);
                fillFromTopRight(midX, midY - 1, n - i);
                midX += delta;
                midY -= delta;
            } else {
                //System.out.println(Corner.BottomLeft);
                fillFromBottomLeft(midX - 1, midY, n - i);
                midX -= delta;
                midY += delta;
            }
        }
    }

    //2^rang == размер стороны г
    //rang == 1 значит больше делить нельзя
    public static void fillFromTopLeft(int x, int y, int rang) {
        if (rang > 1) {
            int delta = (int) pow(2, rang - 2);
            fillFromTopLeft(x, y, rang - 1);
            fillFromTopLeft(x + delta, y + delta, rang - 1);
            fillFromTopRight(x - delta + 1, y + delta, rang - 1);
            fillFromBottomLeft(x + delta, y - delta + 1, rang - 1); //7-7 -> 11-4
        } else {
            arr[y + 1][x + 1] = counter; //x=11 y=3
            arr[y][x + 1] = counter;
            arr[y + 1][x] = counter;
            counter++;
        }
    }

    public static void fillFromTopRight(int x, int y, int rang) {
        if (rang > 1) {
            int delta = (int) pow(2, rang - 2);
            fillFromTopRight(x, y, rang - 1);
            fillFromTopRight(x - delta, y + delta, rang - 1);
            fillFromTopLeft(x + delta - 1, y + delta, rang - 1);
            fillFromBottomRight(x - delta, y - delta + 1, rang - 1); //7-7 -> 11-4
        } else {
            arr[y + 1][x - 1] = counter;
            arr[y][x - 1] = counter;
            arr[y + 1][x] = counter;
            counter++;
        }
    }

    public static void fillFromBottomLeft(int x, int y, int rang) {
        if (rang > 1) {
            int delta = (int) pow(2, rang - 2);
            fillFromBottomLeft(x, y, rang - 1);
            fillFromBottomLeft(x + delta, y - delta, rang - 1);
            fillFromTopLeft(x + delta, y + delta - 1, rang - 1);
            fillFromBottomRight(x - delta + 1, y - delta, rang - 1);
        } else {
            arr[y - 1][x + 1] = counter;//x = 7 y = 8
            arr[y][x + 1] = counter;
            arr[y - 1][x] = counter;
            counter++;
        }
    }

    public static void fillFromBottomRight(int x, int y, int rang) {
        if (rang > 1) {
            int delta = (int) pow(2, rang - 2);
            fillFromBottomRight(x, y, rang - 1);
            fillFromBottomRight(x - delta, y - delta, rang - 1);
            fillFromTopRight(x - delta, y + delta - 1, rang - 1);
            fillFromBottomLeft(x + delta - 1, y - delta, rang - 1);
        } else {
            arr[y - 1][x - 1] = counter;
            arr[y][x - 1] = counter;
            arr[y - 1][x] = counter;
            counter++;
        }
    }

    public static void printSquare() {
        for (int i = 0; i < pow(2, n); i++) {
            for (int j = 0; j < pow(2, n); j++) {
                int len = ("" + counter).length();
                System.out.print(arr[i][j] + String.join("", Collections.nCopies(1 + len - ("" + arr[i][j]).length(), " ")));
            }
            System.out.println();
        }
    }
}