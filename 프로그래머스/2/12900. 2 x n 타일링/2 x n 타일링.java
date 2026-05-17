import java.util.*;

class Solution {
    private static int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, 1);
    
        
        for (int i = 2; i <= n; i++) {
            dp[i] = ((dp[i - 1]) + (dp[i - 2])) % 1_000_000_007;
        }
        
        return dp[n];
        
    }
}