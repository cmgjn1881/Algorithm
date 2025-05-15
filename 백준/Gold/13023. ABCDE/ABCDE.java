
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N; // 노드의 개수
    static int M; // 간선의 개수
    static int u, v; // 간선을 연결하는 두 노드
    static boolean[] visited; // DFS 탐색 시 노드 방문 여부를 저장하는 배열
    static boolean found; // 길이가 5 이상인 경로를 찾았는지 여부를 저장하는 변수
    static ArrayList<ArrayList<Integer>> arr; // 인접 리스트를 사용하여 그래프를 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드의 개수 입력
        M = Integer.parseInt(st.nextToken()); // 간선의 개수 입력

        visited = new boolean[N]; // 노드 개수만큼 방문 배열 초기화
        arr = new ArrayList<>(); // 인접 리스트 초기화
        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>()); // 각 노드에 대한 빈 인접 리스트 생성
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()); // 시작 노드 번호 입력
            v = Integer.parseInt(st.nextToken()); // 끝 노드 번호 입력
            arr.get(u).add(v); // u번 노드의 인접 리스트에 v 추가
            arr.get(v).add(u); // v번 노드의 인접 리스트에 u 추가 (무방향 그래프)
        }

        found = false; // 경로를 찾았는지 여부를 저장하는 변수 초기화
        for (int i = 0; i < N; i++) {
            visited = new boolean[N]; // 각 시작 노드에서 DFS를 시작하기 전에 방문 배열 초기화
            dfs(i, 0); // i번 노드에서 깊이 0으로 DFS 시작
            if (found) break; // 길이가 4 이상인 경로를 찾았으면 더 이상 탐색할 필요 없음
        }
        System.out.println(found ? 1 : 0); // 길이가 4 이상인 경로가 존재하면 1, 아니면 0 출력
    }

    // 깊이 우선 탐색 (DFS) 함수
    static void dfs(int u, int depth) {
        visited[u] = true; // 현재 노드 u를 방문 처리

        // 현재 깊이가 4 이상이면 (시작 노드 포함 5개 이상의 노드를 방문했으면)
        if (depth >= 4) {
            found = true; // 경로를 찾았음을 표시
            return; // 탐색 종료
        }

        // 현재 노드 u의 모든 인접 노드 v에 대해 탐색
        for (int v : arr.get(u)) {
            // 인접 노드 v를 아직 방문하지 않았다면
            if (!visited[v]) {
                dfs(v, depth + 1); // v를 시작 노드로 하여 깊이를 1 증가시켜 재귀 호출
                if (found) return; // 이미 경로를 찾았으면 더 이상 탐색할 필요 없음 (최적화)
            }
        }
        visited[u] = false; // 백트래킹: 다른 경로를 탐색하기 위해 현재 노드 u의 방문 상태를 되돌림
    }
}