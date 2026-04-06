import java.util.*;

class Solution {
    static class Node {
        int d; int cost;
        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] arr : road) {
            adj[arr[0]].add(new Node(arr[1], arr[2]));
            adj[arr[1]].add(new Node(arr[0], arr[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.d] < now.cost) continue;
            
            for (Node next : adj[now.d]) {
                if (dist[next.d] > now.cost + next.cost) {
                    dist[next.d] = now.cost + next.cost;
                    pq.add(new Node(next.d, dist[next.d]));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}