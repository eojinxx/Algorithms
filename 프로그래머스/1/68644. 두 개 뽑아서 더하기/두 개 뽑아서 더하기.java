import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                hs.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = new int[hs.size()];
        int i = 0;
        for (int s : hs) {
            answer[i++] = s;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}