import java.util.*;

class Solution {
    public int solution(int[][] maps) {
         int[] dr = new int[] {0, 0, -1, 1};
        int[] dc = new int[] {-1, 1, 0, 0};
        int n = maps.length - 1, m = maps[0].length - 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == n && now[1] == m) return maps[now[0]][now[1]];

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr >= 0 && nc >= 0 && nr <= n && nc <= m && maps[nr][nc] == 1) {
                    maps[nr][nc] = maps[now[0]][now[1]] + 1;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        return -1;
    }
}