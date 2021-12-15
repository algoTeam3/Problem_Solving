import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 합해서 0에 가장 가까워지는 두 용액을 구해라.
 * 
 * 오름차순 -> 이분탐색 이용
 * 	- 0에 가장 가까운 용액을 구하는 것과 별개로
 * 	- 어떤 용액을 선택할지는 두 용액의 합이 음수냐 양수냐에 따라 용액의 범위를 이분탐색으로 구해나간다.
 * @author chaeu
 *
 */
public class chan_2467 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());	// 전체 용액의 수
		int[] arr = new int[N];	// N개의 용액의 특성값
		st = new StringTokenizer(br.readLine(), " ");
		int[] ans = new int[2];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			// 1. i번째 용액과 i + 1부터 n-1까지의 용액 이분탐색 비교
			int start = i + 1;
			int end = N - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				int sum = 0, dist = 0;
				// 2. i번째 용액과 나머지 용액 중 중간에 있는 용액을 합하기
				sum = arr[i] + arr[mid];
				// 3-1. 합한 용액의 특성값이 음수일 때 범위를 오른쪽으로 옮기기
				if (sum < 0) start = mid + 1;
				// 3-2. 범위를 왼쪽으로 옮기기
				else end = mid - 1;
				// 4. 0에 가장 가까운 혼합 용액 저장
				dist = Math.abs(sum);
				if (dist <= min) {
					min = dist;
					ans[0] = arr[i];
					ans[1] = arr[mid];
				}
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}

}
