import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> sellerMap = new HashMap<>();
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            sellerMap.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String currentName = seller[i];
            int money = amount[i] * 100;

            while(!currentName.equals("-") && money > 0) {
                int tax = money / 10;
                int myMoney = money - tax;

                resultMap.put(currentName, resultMap.getOrDefault(currentName, 0) + myMoney);

                currentName = sellerMap.get(currentName);
                money = tax;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = resultMap.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}