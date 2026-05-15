import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int[] dp = new int[n + 1];
        
        HashSet<String> set = new HashSet<>(Arrays.asList(strs));
        
        
        Arrays.fill(dp, 20_001);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                int start = i - j;
                
                if (start < 0) break;
                
                String sub = t.substring(start, i);
                if (set.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[start] + 1);
                }
            }
        }
        
        return dp[n] > 20_000 ? -1 : dp[n];
    }
}