import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 강의의 수
		int M = Integer.parseInt(st.nextToken());	// 블루레이의 수
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] lecture = new int[N];
		for (int i = 0; i < N; i++) lecture[i] = Integer.parseInt(st.nextToken());
		
		// 오름차순으로 정렬
		Arrays.sort(lecture);
		
		int left = 1;
		int right = lecture[N-1];

		while (left <= right) {
			// 이분탐색을 위한 mid 값
			int mid = (left + right) / 2;
			// 강의 길이의 합
			int sum = 0;
			// 블루레이 개수
			int cnt = 0;
			
			// 블루레이 개수 구하기
			for (int i = 0; i < N; i++) {
				// 강의 길이의 합이 mid보다 크면 개수 + 1
				if (sum + lecture[i] > mid) {
					sum = 0;
					cnt++;
				}
				sum += lecture[i];
			}
			
			// 남은 블루레이 개수 + 1
			if (sum != 0) cnt++;
			
			// 총 필요한 블루레이 개수가 M보다 같거나 작다면
			// 블루레이 크기 줄이기
			if (cnt <= M) right = mid - 1;
			// 총 필요한 블루레이 개수가 M보다 크다면
			// 블루레이 크기 키우기
			else left = mid + 1;
		}
		
		// 최솟값 출력
		System.out.println(left);
	}
}
