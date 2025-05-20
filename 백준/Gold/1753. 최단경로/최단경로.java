
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

//https://www.acmicpc.net/problem/1753
public class Main {
    static int[] distance;
    static ArrayList<ArrayList<Node>> list;

    static class Node{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static void bfs(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if (distance[cur.to] < cur.weight) {
                continue;
            }

            for (Node next : list.get(cur.to)) {
                int cost = distance[cur.to] + next.weight;
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

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++)  {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        bfs(K);

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
