import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main_1207 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int[][] arr;
    static int dots;
    //static double x0, y0;

    static class Point {
        int x;
        int y;
        int number;
        double tangle;
    }

    public static void main(String args[]) {
        FastReader scanner = new FastReader();
        int N = scanner.nextInt();
        Point[] points = new Point[N];
        Point minPoint = new Point();
        minPoint.y = Integer.MAX_VALUE;
        minPoint.number = 0;
        for (int i = 0; i < N; i++) {
            points[i] = new Point();
            points[i].number = i + 1;
            points[i].x = scanner.nextInt();
            points[i].y = scanner.nextInt();
            if (points[i].y < minPoint.y || points[i].y == minPoint.y &&
                    points[i].x < points[minPoint.number].x) {
                minPoint.y = points[i].y;
                minPoint.number = i;
            }
        }
        Point pointA = points[0];
        points[0] = points[minPoint.number];
        points[minPoint.number] = pointA;
        for (int i = 0; i < N; i++) {
            if (points[i].x == points[0].x) points[i].tangle = Math.PI / 2;
            else if (points[i].y == points[0].y) points[i].tangle = 0;
            else points[i].tangle = Math.atan((double) (points[i].y -
                        points[0].y) / (double) (points[i].x - points[0].x));
            if (points[i].tangle < 0) points[i].tangle = points[i].tangle + 2 *
                    Math.PI;
        }
        sortPointsArray(points, 1, N - 1);
        System.out.println(points[0].number + " " + points[N / 2].number);
    }

    static void sortPointsArray(Point[] points, int a, int b) {
        int i = a;
        int j = b;
        double turn = points[(a + b) / 2].tangle;
        while (i <= j) {
            while (points[i].tangle < turn) i++;
            while (points[j].tangle > turn) j--;
            if (i > j) break;
            Point pointA = points[i];
            points[i] = points[j];
            points[j] = pointA;
            i++;
            j--;
        }
        if (a < j) sortPointsArray(points, a, j);
        if (i < b) sortPointsArray(points, i, b);
    }
}