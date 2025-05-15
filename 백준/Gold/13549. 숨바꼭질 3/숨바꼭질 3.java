
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N == M) {
            System.out.println(0);
            return;
        }

        int minTime = bfs(N, M);
        System.out.println(minTime);
    }

    static int bfs(int N, int M) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.offer(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curLocation = cur[0];
            int curTime = cur[1];

            if (curLocation == M) {
                return curTime;
            }

            int nextLocationTeleport = curLocation * 2;
            if (nextLocationTeleport <= 100000 && !visited[nextLocationTeleport]) {
                visited[nextLocationTeleport] = true;
                q.offer(new int[]{nextLocationTeleport, curTime});
            }

            int nextLocationMinus = curLocation - 1;
            if (nextLocationMinus >=0 && !visited[nextLocationMinus]) {
                visited[nextLocationMinus] = true;
                q.offer(new int[]{nextLocationMinus, curTime + 1});
            }

            int nextLocationPlus = curLocation + 1;
            if (nextLocationPlus <= 100000 && !visited[nextLocationPlus]) {
                visited[nextLocationPlus] = true;
                q.offer(new int[]{nextLocationPlus, curTime + 1});
            }
        }

        return -1;
    }
}
