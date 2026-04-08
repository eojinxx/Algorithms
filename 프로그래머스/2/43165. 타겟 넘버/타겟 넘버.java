class Solution {
    private static boolean[] visited;
    private static int[] num;
    private static int answer;
    
    private static void dfs(int idx, int sum, int target) {
        if (idx == num.length) {
            if (sum == target) answer++;
        } else {
            dfs(idx + 1, sum + num[idx], target);
            dfs(idx + 1, sum - num[idx], target);
        }
    }
    public int solution(int[] numbers, int target) {
        num = numbers;
        dfs(0, 0, target);
        return answer;
    }
}