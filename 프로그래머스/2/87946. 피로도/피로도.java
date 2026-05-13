class Solution {
    private static int ans;
    private static boolean[] check;
    
    public static void dfs(int k, int[][] dungeons, int cnt) {
        
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !check[i]) {
                check[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt + 1);
                ans = Math.max(ans, cnt + 1);
                check[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        check  = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return ans;
        
    }
}