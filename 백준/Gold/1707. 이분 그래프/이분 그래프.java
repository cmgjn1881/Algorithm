
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 테스트 케이스 수, 정점 수(V), 간선 수(E), 간선의 두 정점(u, v)
    static int K, V, E, u, v;

    // 각 정점의 색깔 정보를 저장할 배열 (1 또는 -1로 구분)
    static int[] color;

    // 그래프를 인접 리스트로 표현
    static ArrayList<ArrayList<Integer>> list;

    // 정답 저장용 변수 ("YES" 또는 "NO")
    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            answer = "YES";  // 기본값은 YES (이분 그래프라고 가정)

            // 정점(V)과 간선(E) 입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 인접 리스트 초기화 (1부터 V까지 사용하므로 V+1개 생성)
            list = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                list.add(new ArrayList<>());
            }

            // 간선 정보 입력 및 양방향 그래프 구성
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                list.get(u).add(v);
                list.get(v).add(u);
            }

            // 정점 색 배열 초기화 (0은 아직 색칠되지 않음)
            color = new int[V + 1];

            // 모든 정점을 확인 (비연결 그래프일 수도 있으므로)
            for (int j = 1; j <= V; j++) {
                if (color[j] == 0) {
                    if (!BFS(j)) {
                        break;  // 이분 그래프가 아님을 확인하면 중단
                    }
                }
            }

            // 결과 출력
            System.out.println(answer);
        }
    }

    // BFS를 이용한 이분 그래프 판별
    static boolean BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 1;  // 시작 정점은 1로 색칠

        while (!q.isEmpty()) {
            int cur = q.poll();
            // 현재 정점과 연결된 인접 정점들 탐색
            for (Integer i : list.get(cur)) {
                if (color[cur] == color[i]) {
                    // 인접한 두 정점이 같은 색이면 이분 그래프가 아님
                    answer = "NO";
                    return false;
                }
                if (color[i] == 0) {
                    // 아직 색칠되지 않은 정점은 반대 색으로 칠함
                    color[i] = -color[cur];
                    q.offer(i);
                }
            }
        }
        return true;  // 이분 그래프 조건을 만족함
    }
}
