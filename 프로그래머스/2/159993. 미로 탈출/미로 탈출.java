import java.util.*;

class Solution {
    private static int R, C;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static char[][] board;
    
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        board = new char[R][C];
        int[] start = new int[2], lever = new int[2], end = new int[2];
        
        for (int i = 0; i < R; i++) {
            board[i] = maps[i].toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'S') start = new int[] {i, j};
                else if (board[i][j] == 'L') lever = new int[] {i, j};
                else if (board[i][j] == 'E') end = new int[] {i, j};
            }
        }
        
        int toLever = bfs(start, lever);
        if (toLever == -1) return -1;
        
        int toEnd = bfs(lever, end);
        if (toEnd == -1) return -1;
        
        return toEnd + toLever;
        
    }
    
    private static int bfs(int[] start, int[] target) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] check = new boolean[R][C];
        // 0 == 구한 거리 수 
        queue.offer(new int[] {start[0], start[1], 0});
        check[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0], c = now[1], dist = now[2];
            
            if (r == target[0] && c == target[1]) return dist;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && board[nr][nc] != 'X' && !check[nr][nc]) {
                    check[nr][nc] = true;
                    queue.add(new int[] {nr, nc, dist + 1});
                }
            }
        }
        return -1;
    }
}