import java.util.*;

class Solution {
    private static int result;
    private static boolean[] check;
    
    private static void dfs(int lev, int k, int[][] dungeons, int cnt) {
        if (lev == dungeons.length) {
            result = Math.max(result, cnt);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k && !check[i]) {
                check[i] = true;
                dfs(lev + 1, k - dungeons[i][1], dungeons, cnt + 1);
                check[i] = false;
            } else {
                dfs(lev + 1, k, dungeons, cnt);
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(0, k, dungeons, 0);
        
        return result;
    }
}