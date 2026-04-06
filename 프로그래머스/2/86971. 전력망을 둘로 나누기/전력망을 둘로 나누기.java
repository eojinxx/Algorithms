import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static int N, answer;
    
    private static int dfs(int now) {
        visited[now] = true;
        int sum = 0;
        
        for (int next : adj[now]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                sum += cnt; 
            }
        }
        
        return sum + 1;
    }
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = Integer.MAX_VALUE;
        visited = new boolean[n + 1];       
        adj = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        dfs(1);
        return answer;
    }
}