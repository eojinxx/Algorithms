import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int min = Arrays.stream(times).min().getAsInt();
        int max = Arrays.stream(times).max().getAsInt();
        
        long left = (long) min;
        long right = (long) max * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int t : times) {
                sum += (mid / t);
                if (sum >= n) break;
            }
            
            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            } else if (sum < n) {
                left = mid + 1;
            } 
        }
        return answer;
    }
}