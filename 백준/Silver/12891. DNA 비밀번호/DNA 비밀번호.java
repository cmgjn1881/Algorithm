
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12891
// 12891번 - DNA 비밀번호
public class Main {

    // 현재 윈도우에 들어온 문자 하나를 카운트 증가
    public static void addDNA(int[] ps, Character c) {
        if (c.equals('A')) {
            ps[0]++;
        } else if (c.equals('C')) {
            ps[1]++;
        } else if (c.equals('G')) {
            ps[2]++;
        } else if (c.equals('T')) {
            ps[3]++;
        }
    }

    // 현재 윈도우에서 빠지는 문자 하나를 카운트 감소
    public static void deleteDNA(int[] ps, Character c) {
        if (c.equals('A')) {
            ps[0]--;
        } else if (c.equals('C')) {
            ps[1]--;
        } else if (c.equals('G')) {
            ps[2]--;
        } else if (c.equals('T')) {
            ps[3]--;
        }
    }

    public static void main(String[] args) throws IOException{
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] condition = new int[4]; // A, C, G, T 각각의 최소 개수 조건
        int[] ps = new int[4];        // 현재 윈도우에서 A, C, G, T의 개수

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        // DNA 문자열 입력
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        // 각 알파벳 최소 개수 조건 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
            ps[i] = 0; // 초기화
        }

        // 처음 부분 문자열 (원도우)의 알파벳 카운트 초기화
        for (int i = 0; i < P; i++) {
            //System.out.println(str.charAt(i));
            addDNA(ps, str.charAt(i));
        }

        int count = 0;          // 조건을 만족하는 부분 문자열 수
        int startIndex = 0;
        int endIndex = P - 1;   // 처음 윈도우 범위: [0, P-1]

        // 슬라이딩 윈도우 반복
        while (endIndex < S) {
            // 현재 윈도우가 조건을 만족하는지 검사
            if (ps[0] >= condition[0] && ps[1] >= condition[1] &&
                    ps[2] >= condition[2] && ps[3] >= condition[3]) {
                count++; // 조건 만족 시 카운트 증가
            }

            // 마지막 윈도우면 종료 (다음 charAt 접근 시 범위 초과 방지)
            if (endIndex + 1 == S) break;

            // 왼쪽 문자 제거, 오른쪽 문자 추가 (윈도우 1칸 이동)
            deleteDNA(ps, str.charAt(startIndex++));
            addDNA(ps, str.charAt(++endIndex));
        }

        // 정답 출력
        System.out.println(count);
    }
}
