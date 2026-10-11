import java.util.*;

class Solution {
    private static int depth;
    private static int ans = Integer.MIN_VALUE;
    private static boolean[] checked;
    
    private void dfs(int d, int k, int[][] dungeons) {
        for (int i = 0; i < depth; i++) {
            if (checked[i]) continue;
            if (k < dungeons[i][0]) continue;
            
            checked[i] = true;
            ans = Math.max(ans, d + 1);
            dfs(d + 1, k - dungeons[i][1], dungeons);
            checked[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        depth = dungeons.length;
        checked = new boolean[depth];
        dfs(0, k, dungeons);
        
        return ans;
    }
}