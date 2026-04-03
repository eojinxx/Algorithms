class Solution {
    
    private static boolean[] check;
    
    private void dfs(int[][] computers, int start) {
        check[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !check[i]) {
                dfs(computers, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        check = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < computers.length; i++) {
            if (!check[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
}