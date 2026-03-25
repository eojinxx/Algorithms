import java.util.*;

class Solution {
    private static class Info {
        int node, wolf, sheep;
        HashSet<Integer> canVisit;

        Info(int node, int wolf, int sheep, HashSet<Integer> canVisit) {
            this.node = node;
            this.wolf = wolf;
            this.sheep = sheep;
            this.canVisit = canVisit;
        }
    }

    private static ArrayList<Integer>[] tree;
    public static int solution(int[] info, int[][] edges) {
        int answer = Integer.MIN_VALUE;

        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 0, 1, new HashSet<>()));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);
            
            now.canVisit.addAll(tree[now.node]);
            
            for (int next : now.canVisit) {
                HashSet<Integer> set = new HashSet<>(now.canVisit);
                set.remove(next);
                
                if (info[next] == 1) {
                    if (now.sheep > now.wolf + 1) {
                        queue.offer(new Info(next, now.wolf + 1, now.sheep, set));
                    }
                } else {
                    queue.offer(new Info(next, now.wolf, now.sheep + 1, set));
                }
            }
        }
        return answer;

    }
}