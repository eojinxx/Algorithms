import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> discountMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], wantMap.getOrDefault(want[i], 0) + number[i]);
        }



        for (int i = 0; i < discount.length; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);

            if (i >= 9) {
                if (wantMap.equals(discountMap)) ans++;
                discountMap.put(discount[i - 9], discountMap.get(discount[i - 9]) - 1);
                if (discountMap.get(discount[i - 9]) <= 0) discountMap.remove(discount[i - 9]);
            }

        }

        return ans;
    }
}