
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        int sum = 0;
        boolean isZero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                isZero = true;
            }
            else if (num == 1) {
                sum += num;
            } else if (num > 0) {
                plusPQ.add(-num);
            } else {
                minPQ.add(num);
            }
        }

        while (plusPQ.size() >= 2) {
            int a = plusPQ.poll();
            int b = plusPQ.poll();
            sum += a * b;
        }
        if (!plusPQ.isEmpty()) {
            sum = sum + (-plusPQ.poll());
        }

        while (minPQ.size() >= 2) {
            int a = minPQ.poll();
            int b = minPQ.poll();
            sum += a * b;
        }
        if (!minPQ.isEmpty()) {
            if (!isZero) {
                sum += minPQ.poll();
            }
        }

        System.out.println(sum);
    }
}
