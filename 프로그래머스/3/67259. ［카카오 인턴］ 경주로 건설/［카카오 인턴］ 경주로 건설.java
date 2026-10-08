import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int[] dr = new int[] {0, 0, -1, 1};
        int[] dc = new int[] {-1, 1, 0, 0};
        int[][][] dist = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[3], o2[3]));
        queue.offer(new int[] {0, 0, -1, 0});
        
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0], c = now[1];
            
            if (r == N - 1 && c == N - 1) {
                return now[3];
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i]; 
                int nc = c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 1) continue;
                
                if (now[2] == 0 || now[2] == 1) {
                    if (i == 0 || i == 1) {
                        if (dist[nr][nc][i] > now[3] + 100) {
                            dist[nr][nc][i] = now[3] + 100;
                            queue.offer(new int[] {nr, nc, i, now[3] + 100});
                        }
                    } else if (i == 2 || i == 3) {
                        if (dist[nr][nc][i] > now[3] + 600) {
                            dist[nr][nc][i] = now[3] + 600;
                            queue.offer(new int[] {nr, nc, i, now[3] + 600});
                        }
                    }
                } else if (now[2] == 2 || now[2] == 3) {
                    if (i == 0 || i == 1) {
                        if (dist[nr][nc][i] > now[3] + 600) {
                            dist[nr][nc][i] = now[3] + 600;
                            queue.offer(new int[] {nr, nc, i, now[3] + 600});
                        }
                    } else if (i == 2 || i == 3) {
                        if (dist[nr][nc][i] > now[3] + 100) {
                            dist[nr][nc][i] = now[3] + 100;
                            queue.offer(new int[] {nr, nc, i, now[3] + 100});
                        }
                    }
                } else {
                    if (dist[nr][nc][i] > now[3] + 100) {
                        dist[nr][nc][i] = now[3] + 100;
                        queue.offer(new int[] {nr, nc, i, now[3] + 100});
                    }
                }
            }
        }
        
        
        
        return 0;
    }
}