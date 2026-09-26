import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();

        for (String s : report) {
            String[] tmp = s.split(" ");
            String reporter = tmp[0];
            String reportee = tmp[1];

            map.computeIfAbsent(reportee, x -> new HashSet<>()).add(reporter);
        }

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
        }

        int[] ans = new int[id_list.length];

        for (HashSet<String> reporters : map.values()) {
            if (reporters.size() < k) continue;

            for (String reporter : reporters) {
                ans[index.get(reporter)]++;
            }
        }

        return ans;
    }
}