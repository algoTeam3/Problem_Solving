import java.util.*;

public class chan {
    public long solution(int n, int[] times) {
        long answer = 0;    // 모든 사람이 심사 받는데 걸리는 시간의 최솟값
        Arrays.sort(times); // 시간이 짧은 심사관순으로 정렬
        long start = times[0];  // 입국 심사 기다리는 사람 최소 1명일 때 걸리는 시간
        long end = (long)times[times.length - 1] * n;   
        // 이분탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0; // 심사관이 입국 심사 한 사람 수
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            if (count < n) {    // 입국심사 해야 할 사람 수보다 조금했을 때
                start = mid + 1;    // 탐색하는 시간 늘리기 
            } else {    // 입국심사 해야 할 사람 수보다 많이 했을 때
                end = mid - 1;  // 탐색하는 시간 줄이기
            }
        }
        return start;
    }
}