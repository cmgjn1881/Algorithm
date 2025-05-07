
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11729
// 11729번 - 하노이 탑 이동 순서
public class Main {
    public static int cnt = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(1, 2, 3, N);
        System.out.println(cnt);
        System.out.println(sb);

    }

    public static void hanoi(int from, int m, int to, int num) {

        if (num == 0) {
            return;
        }
        hanoi(from, to, m, num - 1);

        //System.out.println(from + " " + to);
        sb.append(from + " " + to + "\n");
        cnt++;

        hanoi(m, from, to, num - 1);
    }
}
