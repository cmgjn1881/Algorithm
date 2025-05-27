import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if ((nr == n - 1) && (nc == m - 1)) {
                    return cur[2] + 1;
                }
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && maps[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
            
        }
        
        return -1;
    }
}