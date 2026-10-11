class Solution {
    private int cnt;
    
    private void dfs(int n, int k, int prev, boolean[][] board) {
        if (n == k) {
            cnt++;
        }
        
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            
            if (k != 0) {
                for (int j = 0; j < k; j++) {
                    if (board[i][j]) {
                        flag = false;
                        break;
                    }
                    
                    for (int l = 0; l < n; l++) {
                        if (Math.abs(k - j) == Math.abs(i - l)) {
                            if (board[l][j]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                
                if (flag) {
                    board[i][k] = true;
                    dfs(n, k + 1, i, board);
                    board[i][k] = false;
                }
                
            } else {
                board[i][k] = true;
                dfs(n, k + 1, i, board);
                board[i][k] = false;
            }
        }
    }
    public int solution(int n) {
        boolean[][] board = new boolean[n][n];
        dfs(n, 0, 0, board);
        return cnt;
    }
}