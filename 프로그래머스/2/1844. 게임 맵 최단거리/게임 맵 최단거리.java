import java.util.*;

class Solution {
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static boolean isValid(int x, int y, int[][] maps) {
        if (x >= 0 && y >= 0 && x < m && y < n && maps[y][x] == 1 && check[y][x] == 0) return true;
        else return false;
    }
    
    private static int[][] check;
    private static int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        
        for (int[] map : maps) {
            m = Math.max(m, map.length);
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int answer = 1;
        check = new int[n][m];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        check[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node now = queue.poll();
                
                if (now.x == m - 1 && now.y == n - 1) return answer;
                
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    
                    if (isValid(nx, ny, maps)) {
                        check[ny][nx] = 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
            answer++;
        }
        
        return -1;
    }
}