
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //int count = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder result = new StringBuilder("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            //count++;

            //조건문 방법
//            int x = deque.removeFirst();
//            if (count % K == 0) {
//                result.append(x).append(", ");
//            } else {
//                deque.add(x);
//            }

            //반복문 방법
            for (int i = 0; i < K - 1; i++) {
                deque.add(deque.removeFirst());
            }
            result.append(deque.removeFirst()).append(", ");

        }
        result.delete(result.length() - 2, result.length()).append(">");
        System.out.println(result);
    }
}
