import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int distToLever = bfs(maps, 'S', 'L');
        if (distToLever == -1) return -1;
        
        int distToExit = bfs(maps, 'L', 'E');
        if (distToExit == -1) return -1;
        
        return distToLever + distToExit;
    }
    
    int bfs(String[] maps, char start, char end) {
        final int n = maps.length, m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        final int[] dr = { 0, 1, 0, -1 };
        final int[] dc = { 1, 0, -1, 0 };
        
        // find starting point
        findStart:
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (maps[r].charAt(c) == start) {
                    visited[r][c] = true;
                    queue.add(new int[]{ r, c, 0 });
                    break findStart;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                
                char nchar = maps[nr].charAt(nc);
                if (visited[nr][nc] || nchar == 'X') continue;
                
                if (nchar == end) {
                    return dist + 1;
                }
                
                visited[nr][nc] = true;
                queue.add(new int[]{ nr, nc, dist + 1 });
            }
        }
        
        return -1;
    }
}