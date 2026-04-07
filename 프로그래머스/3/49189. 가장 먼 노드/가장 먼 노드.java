import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adj;
    private static int[] dist;
    
    private static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int cnt = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                for (int next : adj[now]) {
                    if (dist[next] == 0) {
                        dist[next] = cnt;
                        queue.offer(next);
                    }
                }
            }
            cnt++;
        }
    }
    
    public int solution(int n, int[][] edge) {
        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] arr : edge) {
            adj[arr[0]].add(arr[1]);
            adj[arr[1]].add(arr[0]);
        }
        
        bfs();
        int cnt = 0, max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            System.out.print(dist[i]);
            if (dist[i] > max) {
                max = dist[i];
                cnt = 1;
            } else if (dist[i] == max) cnt++;
        }
        
        return cnt;
    }
    
      
}