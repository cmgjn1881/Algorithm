import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = -Integer.parseInt(br.readLine());
            pq.add(a);
        }

        long tip = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int num = -pq.poll() - count;
            if (num > 0) {
                tip += num;
            }
            count++;
        }

        System.out.println(tip);
    }
}
