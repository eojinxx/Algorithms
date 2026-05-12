import java.util.*;

class Solution {
    public int[] solution(String s) {
       ArrayList<Integer> ans = new ArrayList<>();

        String str = s.substring(2, s.length() - 2);
        String[] arr = str.split("\\},\\{");
        Arrays.sort(arr, Comparator.comparing(String::length));
        
        ans.add(Integer.parseInt(arr[0]));
        
        for (int i = 1; i < arr.length; i++) {
            String[] tmp = arr[i].split(",");
            for (int j = 0; j < tmp.length; j++) {
                if (!ans.contains(Integer.parseInt(tmp[j]))) {
                    ans.add(Integer.parseInt(tmp[j]));
                }
            }
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}