import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12847
// 12847번 - 꿀 아르바이트
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 일급을 담을 배열,
        // 시작 인덱스, 끝 인덱스, 합, 최대 연속 급여를 초기화
        int[] arr = new int[n];
        int startIndex = 0;
        int endIndex = m - 1;
        long sum = 0;
        long max;

        // 일급을 배열에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // m이 0이면 0출력
        if (m == 0) {
            System.out.println(0);
            return;
        }

        // 첫날부터 m번째까지 연속된 날짜의 총 일급을 더하고 max에 저장
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        //System.out.println(sum);
        max = sum;

        // 일급 배열의 인덱스를 벗어나기 전까지
        // 연속된 m일의 합한 급여를 max와 비교하여 계산
        while (endIndex < n - 1) {
            sum -= arr[startIndex];
            startIndex++;
            endIndex++;
            sum += arr[endIndex];
            //System.out.println(sum);
            if (sum > max) {
                max = sum;
            }
        }

        // 최대로 받을 수 있는 급여를 출력
        System.out.println(max);
    }
}
