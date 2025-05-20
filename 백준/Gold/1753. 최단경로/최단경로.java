
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 문제 링크: https://www.acmicpc.net/problem/1753
// 다익스트라 알고리즘을 사용한 최단 거리 구하기
public class Main {
    // 각 정점까지의 최단 거리를 저장할 배열
    static int[] distance;

    // 인접 리스트를 통한 그래프 표현
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();

    // 간선 정보를 담는 클래스
    static class Node implements Comparable<Node> {
        int to;       // 도착 정점
        int weight;   // 가중치

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        // 우선순위 큐에서 가중치를 기준으로 정렬되도록 설정
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // 다익스트라 알고리즘 구현
    static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;  // 시작 정점까지의 거리는 0
        pq.offer(new Node(start, 0));  // 시작 노드를 우선순위 큐에 추가

        while (!pq.isEmpty()) {
            Node cur = pq.poll();  // 현재 가장 짧은 거리의 노드를 꺼냄

            // 이미 더 짧은 경로로 방문된 경우 건너뜀
            if (distance[cur.to] < cur.weight) {
                continue;
            }

            // 현재 정점에서 연결된 모든 인접 정점을 확인
            for (Node next : list.get(cur.to)) {
                int cost = distance[cur.to] + next.weight;

                // 더 짧은 경로를 찾은 경우 업데이트
                if (distance[next.to] > cost) {
                    distance[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 줄: 정점의 수 V, 간선의 수 E
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());  // 정점 개수
        int E = Integer.parseInt(st.nextToken());  // 간선 개수

        int K = Integer.parseInt(br.readLine());   // 시작 정점 번호

        StringBuilder result = new StringBuilder();  // 출력 결과 저장용

        distance = new int[V + 1];  // 1번 정점부터 사용하므로 크기는 V+1
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());           // 인접 리스트 초기화
            distance[i] = Integer.MAX_VALUE;        // 최단 거리 배열 초기화
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());  // 시작 정점
            int v = Integer.parseInt(st.nextToken());  // 도착 정점
            int w = Integer.parseInt(st.nextToken());  // 가중치

            list.get(u).add(new Node(v, w));           // 방향 그래프이므로 u -> v 간선 추가
        }

        // 다익스트라 알고리즘 실행
        bfs(K);

        // 결과 출력
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                result.append("INF\n");  // 도달할 수 없는 정점
            } else {
                result.append(distance[i]).append("\n");  // 최단 거리 출력
            }
        }

        System.out.println(result);
    }
}
