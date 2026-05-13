import java.util.*;

class Node implements Comparable<Node> {
    int cost, r, c;

    public Node(int cost, int r, int c) {
        this.cost = cost;
        this.r = r;
        this.c = c;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost;
    }

}

class Solution {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        boolean[][] check = new boolean[n][n];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 먼저 넣은 다음 뒤에 체크 검사를 하므로 기존에 cost가 높았던거에서 낮은걸로 덮어쓰기가 가능하다.
            // (2,1)의 5가 cost 4짜리가 (2,2)에서 Cost 0짜리로 덮어쓰기가 된다.
            if (check[cur.r][cur.c]) continue;

            check[cur.r][cur.c] = true;

            answer += cur.cost;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (!(nr >= 0 && nc >= 0 && nr < n && nc < n)) continue;

                int tempCost = Math.abs(land[cur.r][cur.c] - land[nr][nc]);
                int newCost = tempCost > height ? tempCost : 0;

                pq.add(new Node(newCost, nr, nc));
            }
        }
        return answer;
    }
}