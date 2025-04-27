import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2075
// 2075번 - N번째 큰 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * N];
        int idx = 0;

        // List에 입력값 추가하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        // List 정렬
        Arrays.sort(arr);
        // N 번째로 큰 수의 인덱스를 이용해 출력
        System.out.println(arr[arr.length - N]);
    }
}

