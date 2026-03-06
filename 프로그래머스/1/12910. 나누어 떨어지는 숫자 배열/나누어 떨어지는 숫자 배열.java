import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).boxed().filter(i -> i % divisor == 0).sorted().mapToInt(Integer::intValue).toArray();
        if (answer.length == 0) return new int[] {-1};
        else return answer;
    }
}