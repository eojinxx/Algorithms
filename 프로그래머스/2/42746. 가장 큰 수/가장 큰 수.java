import java.util.*;
import java.util.stream.*;

class Solution {
   
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((o1, o2) -> o1.charAt(0) == o2.charAt(0) ? (o2 + o1).compareTo(o1 + o2) : Character.compare(o2.charAt(0), o1.charAt(0))).toArray(String[]::new);
        
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        
        return ans.charAt(0) == '0' ? "0" : ans;
    }
    
    
}