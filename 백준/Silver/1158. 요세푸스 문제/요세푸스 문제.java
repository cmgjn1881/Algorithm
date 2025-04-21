
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수할당, 입출력 방법, 조건분에 따라 시간 차이 설명!!

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder result = new StringBuilder("<"); // 결과 출력 문자열 저장

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // 제거할 순번

        // 1번부터 N번까지 덱에 추가
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        // 덱이 빌 때까지 반복
        while (!deque.isEmpty()) {

            // 2. 반복문 방법
            // K-1번만큼 맨 앞 원소를 뒤로 보냄
            for (int i = 0; i < K - 1; i++) {
                deque.add(deque.removeFirst());
            }
            // K번째 사람은 제거(출력)
            result.append(deque.removeFirst()).append(", ");

        }

        // 마지막 출력에서 ", " 제거하고 닫는 괄호 추가
        result.delete(result.length() - 2, result.length()).append(">");
        System.out.println(result); // 최종 결과 출력
    }
}
