import java.util.*;

class Solution {

    static ArrayList<Integer>[] adjList;

    // 거리 배열 전체 반환
    static int[] bfs(int n, int startNode) {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, -1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        dists[startNode] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adjList[cur]) {
                if (dists[next] == -1) {
                    dists[next] = dists[cur] + 1;
                    queue.add(next);
                }
            }
        }
        return dists;
    }

    static int getFarthestNode(int n, int[] dists) {
        int node = 0;
        int maxDist = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dists[i] > maxDist) {
                maxDist = dists[i];
                node = i;
            }
        }
        return node;
    }

    public int solution(int n, int[][] edges) {

         adjList = new ArrayList[n + 1];

         for (int i = 1; i <= n; i++) {
             adjList[i] = new ArrayList<>();
         }

         for (int[] edge : edges) {
             adjList[edge[0]].add(edge[1]);
             adjList[edge[1]].add(edge[0]);
         }

         int[] distFromRandom = bfs(n, 1);
         int a = getFarthestNode(n, distFromRandom);

         int[] distFromA = bfs(n, a);
         int b = getFarthestNode(n, distFromA);

         int[] distFromB = bfs(n, b);

         // 최종 결과
        // 최대 중간 값: 지름의 양 끝점을 기본으로 잡고, 나머지 한 점을 최대한 멀리 있는 애를 구한다.
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (a == i || b == i) continue;
            answer = Math.max(answer, Math.max(distFromA[i], distFromB[i]));
        }
        return answer;
    }
}