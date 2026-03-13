import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int totalW = 0, time = 0, idx = 0;
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        
        while (!queue.isEmpty()) {
            if (idx == truck_weights.length) 
                queue.poll();
            else {
                totalW -= queue.poll();
                if (totalW + truck_weights[idx] <= weight) {
                    queue.offer(truck_weights[idx]);
                    totalW += truck_weights[idx++];
                } else {
                    queue.offer(0);
                }
            }
            time++;
        }
        
        return time;
        
    }
}