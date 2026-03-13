import java.util.*;

// 카드를 사용하지 않고 다음 카드로 넘어갈 수 없다.
// 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없다.
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        for (String s : cards1) {
            queue1.offer(s);
        }
        
        for (String s : cards2) {
            queue2.offer(s);
        }
        
        for (String s : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(s))
                queue1.poll();
            else if (!queue2.isEmpty() && queue2.peek().equals(s))
                queue2.poll();
            else {
                answer = "No";
                break;
            }
        }
        
        
        return answer;
    }
}