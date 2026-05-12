import java.util.*;

class Solution {
   private static int max;
   private static int[] ans;
   private static int[] apeach;

   // 주어진 조합에서 각각의 점수 계산
    private static int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }

    // 최대 차이와 라이언의 과녁 저장
    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if (max < score) {
            max = score;
            ans = ryan.clone();
        } else if (max > 0 && max == score) {
            for (int i = 10; i >= 0; i--) {
                if (ans[i] != ryan[i]) {
                    if (ans[i] < ryan[i]) {
                        ans = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
   private static void backtrack(int n, int idx, int[] ryan) {
       if (n == 0) {
           calculateDiff(ryan);
           return;
       }

       // 순서는 상관없으므로 조합사용
       // 화살을 한 발씩 쏘는 게 아니라, "각 점수(0~10점) 과녁에 화살을 몇 발 쏠 것인가?"를 결정하는 방식\
       for (int i = idx; i <= 10; i++) {  // idx: 현재 몇 점짜리 과녁을 보고 있는지
           int cnt = Math.min(n, apeach[i] + 1);
           ryan[i] = cnt;
           backtrack(n - cnt, i + 1, ryan);
           ryan[i] = 0;
       }
   }

   public static int[] solution(int n, int[] info) {
       apeach = info;
       max = 0;
       backtrack(n, 0, new int[11]);
       return max == 0 ? new int[] {-1} : ans;
   }
}