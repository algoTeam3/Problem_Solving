import java.util.Arrays;

public class programmers_lv3_입국심사 {

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7, 10}));
	}

    public static long solution(int n, int[] times) {
    	long answer = Long.MAX_VALUE;
        
        // 오름차순 정렬
        Arrays.sort(times);
        long left = 1;
        // 가장 늦게 끝나는 시간
        long right = (long) times[times.length-1] * n;
        
        while (left <= right) {
            // 이분탐색을 위한 mid 값
        	long mid = (left + right) / 2;
            // 해당 시간에 각 심사대의 최대 심사 수의 합을 구할 변수
        	long count = 0;
            
            // times 배열을 순회하면서
            for (int i = 0; i < times.length; i++) {
                // 해당 시간의 심사 수를 계산하여 count 변수에 더하기
                count += mid / times[i];
            }
            
            // 만일 count 변수가 사람 수 n 값보다 같거나 크다면
            // answer 변수와 mid 변수 중에 작은 값을 answer 변수에 저장
            // mid의 왼쪽을 탐색
            if (count >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
            // 만일 count 변수가 사람 수 n 값보다 작다면
            // mid의 오른쪽을 탐색
            else left = mid + 1;
        }
        return answer;
    }
}
