import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1726 {
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

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        long N = scanner.nextLong();
        long[] coordinatesX = new long[(int) N];
        long[] coordinatesY = new long[(int) N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            coordinatesX[i] = scanner.nextInt();
            coordinatesY[i] = scanner.nextInt();
        }
        Arrays.sort(coordinatesX);
        Arrays.sort(coordinatesY);
        for (int i = 1; i < N; i++) {
            sum += ((coordinatesX[i] - coordinatesX[i - 1]) + (coordinatesY[i] - coordinatesY[i - 1])) * i * (N - i) * 2;
        }
        sum = sum / (N * (N - 1));
        System.out.println(sum);
    }
}