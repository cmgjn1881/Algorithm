
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer; 

public class Main {
    // 그래프를 인접 리스트(ArrayList<ArrayList<Integer>>)로 표현
    // graph.get(i)는 i번 정점과 연결된 정점들의 리스트를 담음
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 방문 여부를 기록하는 배열. visited[i]가 true이면 i번 정점을 방문했음을 의미
    static boolean[] visited;
    // 시작 정점으로부터 각 정점까지의 최단 거리를 저장할 배열
    static int[] distance;
    // 그래프의 정점(사람) 수 N, 간선(친구 관계) 수 M
    static int N, M;

    /**
     * BFS(너비 우선 탐색)를 수행하여 start 정점에서 다른 모든 정점까지의 최단 거리를 계산하고,
     * 그 거리들의 총합 (케빈 베이컨 수)을 반환합니다.
     *
     * @param start BFS를 시작할 정점의 번호 (특정 사람)
     * @return start 정점으로부터 다른 모든 정점까지의 최단 거리 합 (케빈 베이컨 수)
     */
    static int bfs(int start) {
        // 각 BFS를 시작할 때마다 visited와 distance 배열을 초기화합니다.
        // 이는 각 시작 정점에서 독립적인 BFS를 수행하기 위함입니다.
        // boolean 배열은 기본적으로 false로, int 배열은 기본적으로 0으로 초기화됩니다.
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        Queue<Integer> q = new LinkedList<>(); // BFS 탐색을 위한 큐 선언
        int totalBaconSum = 0; // 케빈 베이컨 수를 저장할 변수

        // BFS 시작 정점 초기화
        visited[start] = true; // 시작 정점을 방문 처리
        distance[start] = 0;   // 시작 정점 자신의 거리는 0
        q.offer(start);        // 큐에 시작 정점 추가

        // 큐가 비어있지 않은 동안 반복 (BFS 탐색)
        while (!q.isEmpty()) {
            int cur = q.poll(); // 큐에서 현재 정점(노드)을 꺼냄

            // 현재 정점과 연결된 모든 이웃 정점들을 순회
            for (int next : graph.get(cur)) {
                // 아직 방문하지 않은 이웃 정점이라면
                if (!visited[next]) {
                    visited[next] = true; // 방문 처리
                    // 다음 정점의 거리는 현재 정점의 거리 + 1
                    distance[next] = distance[cur] + 1;
                    q.offer(next); // 큐에 추가하여 다음 탐색 대상으로 예약
                }
            }
        }

        // BFS가 종료된 후, 시작 정점에서 다른 모든 정점까지의 거리 합(케빈 베이컨 수)을 계산합니다.
        for (int i = 1; i <= N; i++) {
            if (i == start) { // 자기 자신(start)과의 거리는 케빈 베이컨 수 합산에서 제외
                continue;
            }
            totalBaconSum += distance[i]; // 각 정점까지의 거리를 총합에 더함
        }

        return totalBaconSum; // 계산된 케빈 베이컨 수를 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 줄에서 정점 수 N과 간선 수 M을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점(사람)의 수
        M = Integer.parseInt(st.nextToken()); // 간선(친구 관계)의 수

        int minBaconSum = Integer.MAX_VALUE; // 지금까지 발견된 최소 케빈 베이컨 수 (초기값: 최대 정수)
        int resultPerson = 0; // 최소 케빈 베이컨 수를 가지는 사람의 번호를 저장할 변수

        // 그래프의 인접 리스트 초기화
        // 1번 정점부터 N번 정점까지 사용하므로 N+1 크기로 ArrayList를 추가
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // M개의 친구 관계(간선) 정보를 입력받아 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 사람 A
            int b = Integer.parseInt(st.nextToken()); // 사람 B

            // 친구 관계는 양방향이므로 양쪽에 모두 추가 (무방향 그래프)
            graph.get(a).add(b); // A와 B 연결
            graph.get(b).add(a); // B와 A 연결
        }

        // 각 사람(정점) i에 대해 BFS를 시작하여 '케빈 베이컨 수'를 계산하고 최소값을 찾음
        // N명의 사람 각각을 시작점으로 하여 BFS를 수행
        for (int i = 1; i <= N; i++) {
            int currentBaconSum = bfs(i); // 현재 사람 i의 케빈 베이컨 수 계산

            // 현재 계산된 케빈 베이컨 수가 지금까지의 최소값보다 작으면 갱신
            if (currentBaconSum < minBaconSum) {
                minBaconSum = currentBaconSum; // 최소 케빈 베이컨 수 갱신
                resultPerson = i; // 해당 사람의 번호 저장
            }
            // 케빈 베이컨 수가 동일할 경우, 번호가 더 작은 사람을 선택
            else if (currentBaconSum == minBaconSum) {
                resultPerson = Math.min(resultPerson, i);
            }
        }

        // 최종적으로 최소 케빈 베이컨 수를 가지는 사람의 번호 출력
        System.out.println(resultPerson);
    }
}