
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열의 크기 N 입력
        int[] arr = new int[N]; // 수열 저장할 배열 생성
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 오큰수를 구하기 위한 스택 생성
        int[] result = new int[N]; // 결과값 저장 배열 생성

        st = new StringTokenizer(br.readLine());

        // 수열 입력 받아서 저장
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과의 마지막은 -1로 설정하고 스택에 마지막 값 push
        result[N - 1] = -1;
        stack.push(arr[N - 1]);

        // 반복문으로 수열의 뒷부분부터 결과값 구하기
        for (int i = N - 2; i >= 0; i--) {
            // 스택의 맨위 값이 수열의 값보다 크면 해당 인덱스의 결과값을 스택의 peek값으로 배정
            if (!stack.isEmpty() && stack.peek() > arr[i]) {
                result[i] = stack.peek();
            } else {
                // 아니라면 스택이 비어있지 않고 peek한 값이 배열의 값보다 클 때까지 pop
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                // 스택에 남은 값이 없다면 -1, 큰 값이 있다면 해당 인덱스의 결과값을 스택의 peek값으로 배정
                if (!stack.isEmpty() && stack.peek() > arr[i]) {
                    result[i] = stack.peek();
                } else {
                    result[i] = -1;
                }
            }
            // 해당 수열 값을 스택에 push
            stack.push(arr[i]);
        }

        // 결과값 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]);
            if (i < N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
