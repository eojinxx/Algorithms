import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> resultList = new ArrayList<>();
        String str = s.substring(2, s.length() - 2);
        String[] arr = str.split("\\},\\{");
        Arrays.sort(arr, Comparator.comparing(String::length));
        
        resultList.add(Integer.parseInt(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            String[] tmp = arr[i].split(",");
            for (String a : tmp) {
                if (!resultList.contains(Integer.parseInt(a))) {
                    resultList.add(Integer.parseInt(a));
                }
            }
        }
        
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}