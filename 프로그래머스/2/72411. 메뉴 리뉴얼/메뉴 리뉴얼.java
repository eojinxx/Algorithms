import java.util.*;


class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        // 1. 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴를 구성한다.
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values().stream()
                    .max(Comparator.naturalOrder())
                    .ifPresent(cnt -> count.entrySet()
                            .stream()
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    public static void combinations(int idx, char[] order, String result) {
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 해당 코스의 수를 1증가
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }   
}
    