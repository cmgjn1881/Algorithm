
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int x = 0;

            // 인자를 필요로 하는 명령어에서만 두 번째 토큰 읽기
            if (command.equals("push_front") || command.equals("push_back")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "push_front":
                    deque.addFirst(x);
                    break;
                case "push_back":
                    deque.add(x);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.removeFirst());
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.removeLast());
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
            }
        }
    }
}
