import java.util.*;

class Solution {
    private static ArrayList<Integer>[] win;
    private static ArrayList<Integer>[] lose;
    private static boolean[] visited;
    
    private static int dfs(ArrayList<Integer>[] adj, int now) {
        visited[now] = true;
        int count = 1;
        
        for (int next : adj[now]) {
            if (!visited[next]) {
                count += dfs(adj, next);
            }    
        }
        
        return count;
        
    }
    
    public int solution(int n, int[][] results) {
        win = new ArrayList[n + 1]; lose = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            win[result[0]].add(result[1]);
            lose[result[1]].add(result[0]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            int winCnt = dfs(win, i) - 1;
            
            Arrays.fill(visited, false);
            int loseCnt = dfs(lose, i) - 1;
            
            if ((winCnt + loseCnt) == n - 1) answer++;
        }
        
        return answer;
    }
}