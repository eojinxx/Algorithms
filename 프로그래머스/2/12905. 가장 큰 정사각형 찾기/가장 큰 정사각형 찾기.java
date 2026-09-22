import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int r = board.length, c = board[0].length;
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (board[i][j] == 1)
                
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i - 1][j - 1]), board[i][j - 1]) + 1;
            }
        }
        
        int max = Arrays.stream(board)
            .flatMapToInt(Arrays::stream)
            .max()
            .getAsInt();
        return max * max;
    }
}
