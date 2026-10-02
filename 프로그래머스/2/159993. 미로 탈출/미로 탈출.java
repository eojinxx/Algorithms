import java.util.*;

class Solution {
    private char[][] miro;
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[] start = null, lever = null, finish = null;
        miro = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String tmp = maps[i];
            for (int j = 0; j < m; j++) {
                if (tmp.charAt(j) == 'S') {
                    miro[i][j] = 'S';
                    start = new int[] {i, j};
                } else if (tmp.charAt(j) == 'E') {
                    miro[i][j] = 'E';
                    finish = new int[] {i, j};
                } else if (tmp.charAt(j) == 'L') {
                    miro[i][j] = 'L';
                    lever = new int[] {i, j};
                } else if (tmp.charAt(j) == 'O') {
                    miro[i][j] = 'O';
                } else if (tmp.charAt(j) == 'X') {
                    miro[i][j] = 'X';
                }  
            }
        }
        
        int ans = 0;
        int a = bfs(start, lever);
        if (a == -1) return -1;
        ans += a;
        int b = bfs(lever, finish);
        if (b == -1) return -1;
        
        return ans + b;
    }
    
    private int bfs(int[] start, int[] finish) {
        int[] dr = new int[] {-1, 1, 0, 0};
        int[] dc = new int[] {0, 0, -1, 1};
        int[][] dist = new int[miro.length][miro[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (now[0] == finish[0] && now[1] == finish[1]) 
                return dist[now[0]][now[1]];
            
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                
                if (nr >= 0 && nc >= 0 && nr < miro.length && nc < miro[0].length && dist[nr][nc] == 0) {
                    if (miro[nr][nc] != 'X') {
                        dist[nr][nc] = dist[now[0]][now[1]] + 1;    
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        
        return -1;
    }
}