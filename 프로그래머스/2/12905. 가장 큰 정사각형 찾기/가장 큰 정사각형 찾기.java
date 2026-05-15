import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int ans = 0;
        int r = board.length;
        int c = board[0].length;
        
        if (r == 1 || c == 1) {
            return Arrays.stream(board[0]).min().getAsInt();
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (board[i][j] == 1)
                    board[i][j] = Math.min(Math.min(board[i][j - 1], board[i - 1][j]), board[i - 1][j - 1]) + 1;
            }
        }
        
        for (int[] tmp : board) {
            for (int num : tmp) {
                ans = Math.max(ans, num);
            }
        }
        return ans * ans;
    }
}