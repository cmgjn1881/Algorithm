
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N: 정점 개수, M: 간선 개수, V: 시작 정점
    static int N, M, V, u, v;

    // 정점 방문 여부 확인용 배열
    static boolean[] visited;

    // 인접 리스트 그래프
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 줄: 정점 수, 간선 수, 시작 정점
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());



        // 인접 리스트 초기화 (정점 번호 1부터 N까지 사용하므로 N+1개 생성)
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            list.get(u).add(v);
            list.get(v).add(u);
        }

        // 인접 정점 번호를 오름차순으로 정렬 (문제에 따라 정점 방문 순서 일관성 확보용)
        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        // 방문 배열 초기화
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        DFS(V);

        System.out.println();

        // 방문 배열 초기화
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        // BFS 수행
        BFS(V);
    }

    // BFS 탐색
    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        // 시작 정점 출력
        System.out.print(v + " ");

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 현재 정점의 인접 정점 순회
            for (Integer i : list.get(cur)) {
                if (!visited[i]) {
                    q.offer(i);            // 큐에 삽입
                    visited[i] = true;     // 방문 처리
                    System.out.print(i + " ");  // 방문 정점 출력
                }
            }
        }
    }

    // DFS 탐색
    static void DFS(int v) {
        
        // 방문 처리
        visited[v] = true;
        
        // 방문 정점 출력
        System.out.print(v + " ");
        
        // 재귀로 계산
        for (Integer i : list.get(v)) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
