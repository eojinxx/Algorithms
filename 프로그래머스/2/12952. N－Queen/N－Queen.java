import java.util.*;

class Solution {
    private static int[] board;
    private static int ans;
    
    private static void dfs(int col) {
        if (col == board.length) ans++;
        
       for (int i = 0; i < board.length; i++) {
           boolean isValid = true;
           for (int j = 0; j < col; j++) {
               if (board[j] == i || (Math.abs(board[j] - i) == Math.abs(j - col))) {
                  isValid = false;
                   break;
               }
           }
           
           if (isValid) {
               board[col] = i;
               dfs(col + 1);
               board[col] = 0;
           }
       }
    
    }
    
    public int solution(int n) {
        board = new int[n];
        dfs(0);
        return ans;
    }
}