import java.util.*;

class Solution {    
    public int solution(int N, int[][] road, int K) {
        ArrayList<int[]>[] list = new ArrayList[N + 1];
        
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int[] arr : road) {
            list[arr[0]].add(new int[] {arr[1], arr[2]});
            list[arr[1]].add(new int[] {arr[0], arr[2]});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int n = now[0]; int weight = now[1];
            
            if (dist[n] < weight) continue;
            
            for (int[] next : list[n]) {
                if (next[1] + weight < dist[next[0]]) {
                    dist[next[0]] = next[1] + weight;
                    pq.offer(new int[] {next[0], next[1] + weight});
                }
            }
        }
        
        int ans = 0;
        for (int i : dist) {
            if (K >= i) ans++;
        }
        
        return ans;
    }
}