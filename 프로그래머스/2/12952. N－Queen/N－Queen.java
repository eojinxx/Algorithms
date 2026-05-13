import java.util.*;

class Solution {
    private static int[] location;
    private static int ans;
    private static int N;
    
    private static void backtrack(int col) {
        if (col == N) {
            ans++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if(isValid(i, col)) {
                location[col] = i;
                backtrack(col + 1);
                location[col] = 0;
            }
        }
    }
    
    private static boolean isValid(int row, int col) {
        for (int c = 0; c < col; c++) {
            int r = location[c];
            if (r == row || c == col || (Math.abs(row - r) == Math.abs(col - c))) {
                return false;
            }
        }
        
        return true;
    }
    public int solution(int n) {
        location = new int[n];
        N = n;
        backtrack(0);
        return ans;
        
        
    }
}