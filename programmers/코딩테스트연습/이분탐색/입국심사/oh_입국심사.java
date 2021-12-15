import java.util.Arrays;

public class oh_입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long min = 0;
        long max = (long) times[times.length - 1]*n;

        while (min <= max) {
            long mid = (max + min) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                min = mid + 1;
                answer = min;
            } else {
                max = mid - 1;
            }

        }
        return answer;
    }
}
