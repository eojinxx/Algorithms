import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) score[0] += 1;
            if (answers[i] == b[i % b.length]) score[1] += 1;
            if (answers[i] == c[i % c.length]) score[2] += 1;
        }
        
        int maxScore = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        if (maxScore == score[0]) list.add(1);
        if (maxScore == score[1]) list.add(2);
        if (maxScore == score[2]) list.add(3);
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}