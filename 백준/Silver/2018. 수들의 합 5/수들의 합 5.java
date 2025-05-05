
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2018
// 1218번 - 수들의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        // 횟수, 시작 숫자, 끝 숫자, 연속된 숫자의 합을 초기화 
        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        // 끝 숫자가 마지막까지 왔다는 것은 start와 end가 동일해졌다는 것으로 종료
        while (end <= N) {
            
            // 합이 N과 같다면 count증가, 끝 숫자를 하나 올리고
            // 합에 증가된 끝 숫자를 더한다
            if (sum == N) {
                // 숫자 범위를 확인하기 위한 출력코드
                //System.out.println(start + " ~ " + end);
                count++;
                end++;
                sum += end;
            } 
            // 합이 N보다 크다면 시작 숫자를 빼고
            // 시작 숫자를 올린다
            else if (sum > N) {
                sum -= start;
                start++;
            } 
            // 합이 N보다 작다면 끝 숫자를 올리고
            // 합에 증가된 끝 숫자를 더한다.
            else {
                end++;
                sum += end;
            }
        }

        // 총 횟수를 출력
        System.out.println(count);
    }
}
