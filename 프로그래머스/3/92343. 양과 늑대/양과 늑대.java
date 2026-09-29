import java.util.*;

class Solution {
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> candidates;
        
        Info(int node, int sheep, int wolf, HashSet<Integer> candidates) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.candidates = candidates;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        ArrayList<Integer>[] tree = new ArrayList[info.length];
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
        }
        
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(0, 1, 0, new HashSet()));
        
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            ans = Math.max(ans, now.sheep);
            
            now.candidates.addAll(tree[now.node]);
            
            for (int next : now.candidates) {
                HashSet<Integer> set = new HashSet<>(now.candidates);
                set.remove(next);
                
                if (info[next] == 0) {                     queue.offer(new Info(next, now.sheep + 1, now.wolf, set));
                } else if (now.sheep > now.wolf + 1){
                    queue.offer(new Info(next, now.sheep, now.wolf + 1, set));
                }
            }
        }
        
        return ans;
        
    }
}