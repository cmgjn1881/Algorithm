
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/21939
// 21939번 - 문제 추천 시스템 Version 1
public class Main {
    // 문제 클래스: 문제 번호(num), 난이도(level)를 갖고 있으며, 정렬 기준을 정의
    static class Problem implements Comparable<Problem> {
        int num, level;

        Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        // TreeSet에 저장될 때의 정렬 기준 정의
        // 난이도가 같으면 문제 번호 오름차순, 아니면 난이도 오름차순
        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) return this.num - o.num;
            return this.level - o.level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // TreeSet: 자동 정렬 + 중복 제거. 난이도 기준으로 문제를 정렬함
        TreeSet<Problem> set = new TreeSet<>();

        // 문제 번호로 난이도를 추적하기 위한 Map
        Map<Integer, Integer> map = new HashMap<>();

        // 초기 문제 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 문제 정보 입력받기 (문제 번호, 난이도)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pNum = Integer.parseInt(st.nextToken());
            int pLevel = Integer.parseInt(st.nextToken());

            Problem p = new Problem(pNum, pLevel);
            set.add(p);               // 문제를 TreeSet에 추가
            map.put(pNum, pLevel);    // 문제 번호로 난이도를 저장
        }

        // 명령의 수 입력
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                // 새 문제 추가 명령
                int pNum = Integer.parseInt(st.nextToken());
                int pLevel = Integer.parseInt(st.nextToken());

                set.add(new Problem(pNum, pLevel));  // TreeSet에 추가
                map.put(pNum, pLevel);               // Map에도 추가

            } else if (command.equals("recommend")) {
                // 추천 명령: 가장 어려운 문제(1) 또는 가장 쉬운 문제(-1)
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    System.out.println(set.last().num);   // 가장 어려운 문제 번호 출력
                } else {
                    System.out.println(set.first().num);  // 가장 쉬운 문제 번호 출력
                }

            } else if (command.equals("solved")) {
                // 문제 해결 명령: 문제 번호로 삭제
                int pNum = Integer.parseInt(st.nextToken());
                int pLevel = map.get(pNum);                 // 난이도 확인
                set.remove(new Problem(pNum, pLevel));      // TreeSet에서 삭제
                map.remove(pNum);                           // Map에서도 삭제
            }
        }
    }
}
