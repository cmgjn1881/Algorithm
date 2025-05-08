
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1253
// 1253번 - 좋다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수 입력
        long[] arr = new long[N]; // 수를 담을 배열
        int count = 0; // 좋은 수의 개수

        // 수열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 정렬하여 투 포인터 적용 가능하게 만듦
        Arrays.sort(arr);

        // 모든 수에 대해 검사 (이 수가 두 수의 합으로 표현 가능한지)
        for (int i = 0; i < N; i++) {
            long findNum = arr[i]; // 현재 검사할 수
            int startIndex = 0; // 투 포인터 시작
            int endIndex = N - 1;

            while (startIndex < endIndex) {
                long sum = arr[startIndex] + arr[endIndex];

                if (sum == findNum) {
                    // 자기 자신을 두 수 중 하나로 쓰면 안됨
                    if (startIndex != i && endIndex != i) {
                        count++; // 조건 만족 → 좋은 수
                        break;
                    } else if (startIndex == i) {
                        startIndex++; // 자기 자신이면 포인터 이동
                    } else if (endIndex == i) {
                        endIndex--;
                    }
                } else if (sum < findNum) {
                    // 합이 작으면 왼쪽 포인터 증가
                    startIndex++;
                } else {
                    // 합이 크면 오른쪽 포인터 감소
                    endIndex--;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
        br.close();
    }
}
