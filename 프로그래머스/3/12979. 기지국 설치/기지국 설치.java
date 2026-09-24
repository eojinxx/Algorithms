class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        int location = 1;
        int idx = 0;
        
        while (location <= n) {
            // 기지국이 설치된 위치에 도달할 경우
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            } else {
                location += 2 * w + 1; // 기지국을 설치하고 해당 범위를 넘어감
                ans++;
            }
        }
        return ans;
    }
}