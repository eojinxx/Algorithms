import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int ans = 0;
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
            if (budget < d[i]) break;
            budget -= d[i];
            ans++;
        }
        
        return ans;
    }
}