import java.util.*;

class Solution {
    public String solution(int[] numbers) {
       String[] arr = Arrays.stream(numbers).mapToObj(i -> String.valueOf(i)).sorted((o1, o2) -> o1.charAt(0) == o2.charAt(0) ? (o2 + o1).compareTo(o1 + o2): o2.compareTo(o1)).toArray(String[]::new);
        
        String ans = "";
        for (String s : arr) {
            ans += s;
        }
        
        return ans.charAt(0) == '0' ? "0" : ans;
    }
}