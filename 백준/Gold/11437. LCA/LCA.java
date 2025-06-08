
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int MAX = 100001;         // 최대 노드 수
    static int LOG = 17;             // 2^17 = 131072 > 100000
    static int[][] parent = new int[MAX][LOG];
    static int[] depth = new int[MAX];

    // 공통 조상노드 구하는 함수
    static int findLCA(int a, int b) {

        // 두 노드의 깊이를 같게 만듦 (a가 더 깊도록 조정)
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // a를 위로 올려서 b와 같은 깊이로 맞춤
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = parent[a][i];
            }
        }

        // 깊이를 맞췄는데 이미 같은 노드면 그게 LCA
        if (a == b) return a;

        // a와 b가 같아질 때까지 동시에 위로 점프
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        // 바로 위 부모가 공통 조상
        return parent[a][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 트리 구현 tree
        Map<Integer, List<Integer>> tree = new HashMap<>();
        // 방문 체크용 배열
        boolean[] visited = new boolean[N + 2];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            tree.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // BFS로 깊이(depth)와 2^0번째 부모(parent[v][0]) 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : tree.getOrDefault(cur, new ArrayList<>())) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;   // 깊이 설정
                    parent[next][0] = cur;          // immediate parent 설정
                    q.add(next);
                }
            }
        }

        // Binary Lifting 전처리: 2^k 번째 조상 미리 계산
        for (int i = 1; i < LOG; i++) {
            for (int v = 1; v <= N; v++) {
                parent[v][i] = parent[parent[v][i - 1]][i - 1];
            }
        }

        // 쌍으로 주어진 노드의 최소조상노드 구하기
        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lcaNode = findLCA(a, b);
            result.append(lcaNode).append("\n");
        }

        // 결과값 출력
        System.out.println(result);
    }
}
