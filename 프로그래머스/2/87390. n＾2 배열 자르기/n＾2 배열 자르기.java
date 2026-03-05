class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];
        
        for (long i = left; i <= right; i++) {
            long r = i / n;
            long c = i % n;
            
            answer[(int) (i - left)] =  (int) (Math.max(r, c) + 1);
        }   
        return answer;
    }
}