import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2075
// 2075번 - N번째 큰 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N을 입력 받음
        int N = Integer.parseInt(br.readLine());
        // 최소 힙을 우선순위큐로 구현
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
	// StringTokenizer를 사용하여 한 줄을 입력 받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
		// N번째로 큰 수를 빼기 위해 숫자 앞에 '-'를 추가 후 힙에 저장
                minHeap.add(-Integer.parseInt(st.nextToken()));
            }
        }

        // N - 1번째 큰 수까지 제거
        for (int i = 0; i < N - 1; i++) {
            minHeap.poll();
        }

	// N번째로 큰 수 출력
        System.out.println(-minHeap.poll());
    }
}

