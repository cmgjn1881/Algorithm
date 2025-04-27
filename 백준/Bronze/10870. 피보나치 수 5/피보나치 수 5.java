import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10870
// 10870반 = 피보나치 수 5
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(pibo(n));
    }

    // 피보나치 함수 작성 (재귀)
    public static int pibo(int n) {

        if (n == 0) return 0; // n이 0 이면 0 리턴
        if (n == 1) return 1; // n이 1 이면 1 리턴

        return pibo(n - 1) + pibo(n - 2); // 바로 앞의 두 수를 더해서 리턴
    }
}
