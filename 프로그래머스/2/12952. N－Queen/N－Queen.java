class Solution {
    private int[] location;
    private int ans;
    private int N;
    
    private void dfs(int col) {
        if (N == col) {
            ans++;
            return;
        } 
        
        for (int i = 0; i < N; i++) {
            if (isValid(i, col)) {
                location[col] = i;
                dfs(col + 1);
                location[col] = -1;
            }
        }
    }
    
    private boolean isValid(int row, int col) {
        for (int i = 0; i < col; i++) {
            int r = location[i];
            if (r == row || Math.abs(row -r) == Math.abs(col - i)) {
                return false;
            }
        } 
        
        return true;
    }
    
    public int solution(int n) {
        location = new int[n];
        N = n;
        dfs(0);
        return ans;
    }
}