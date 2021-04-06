import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1494 {

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

    static ArrayList<Integer> balls;
    static int top = 0;

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int N = scan.nextInt();
        int max = 0;
        LinkedList<Integer> balls = new LinkedList<>();
        for (int i = 0; i < N; i++){
            int ball = scan.nextInt();
            if (ball > max){
                for (int j = max + 1; j <= ball-1; j++){
                    balls.addFirst(j);
                }
                max = ball;
            }
            else{
                if (ball == balls.getFirst()){
                    balls.removeFirst();
                }
                else {
                    System.out.println("Cheater");
                    System.exit(0);
                }
            }
        }
        System.out.println("Not a proof");
    }
}
