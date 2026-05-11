import java.util.*;

class Solution {
    private static int result;
    private static boolean[] check;
    
    private static void dfs(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k && !check[i]) {
                check[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt + 1);
                check[i] = false;
            }
        }
        result = Math.max(result, cnt);
    }
    
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return result;
    }
}