
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        // 1. 각 작업이 며칠 뒤에 끝나는지 계산해서 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double) remain / speeds[i]);
            days.offer(day);
        }

        // 2. 배포일 묶기
        while (!days.isEmpty()) {
            int currentDay = days.poll(); // 기준이 되는 첫 번째 기능의 완성일
            int cnt = 1;

            // 뒤에 있는 기능 중 기준일보다 빨리 끝나는 애들은 다 같이 나감
            while (!days.isEmpty() && days.peek() <= currentDay) {
                days.poll();
                cnt++;
            }
            ans.add(cnt);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}