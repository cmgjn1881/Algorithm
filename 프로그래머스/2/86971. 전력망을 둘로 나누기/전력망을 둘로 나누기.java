import java.util.*;

class Solution {
    boolean[] visited;
    int mindiff = 100;
    public int dfs(int n, int start, Map<Integer, List<Integer>> map) {
        visited[start] = true;
        int cnt = 1;
        for (int next : map.get(start)) {
            if (!visited[next]) {
                cnt += dfs(n, next, map);
            }
        }
        
        mindiff = Math.min(mindiff, Math.abs(n - cnt * 2));
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        
        dfs(n, 1, map);
        
        return mindiff;
    }
}