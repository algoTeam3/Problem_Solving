import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 전체 용액의 수
		int[] arr = new int[N];						// 용액들의 특성 값
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer_left = 0;
		int answer_right = 0;
		// 양쪽부터 탐색하기 위한 용액 인덱스
		int left = 0;
		int right = N-1;
		// 0에 가까운 혼합 특성값 찾기
		int min = Integer.MAX_VALUE;
		
		while (left < right) {
			// 용액 혼합
			int sum = arr[left] + arr[right];
			
			// 최솟값 갱신
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				answer_left = arr[left];
				answer_right = arr[right];
			}
			
			// 만일 오른쪽에 위치한 값이 왼쪽에 위치한 값보다 절대값이 더 크다면 오른쪽 인덱스 감소시키기
			if (Math.abs(arr[left]) < Math.abs(arr[right])) {
				right--;
			}
			// 만일 왼쪽에 위치한 값이 오른쪽에 위치한 값보다 절대값이 더 크다면 왼쪽 인덱스 증가시키기
			else if (Math.abs(arr[left]) > Math.abs(arr[right])) {
				left++;
			}
			// 만일 양쪽 절대값이 같다면, 양쪽 인덱스 좁히기
			else {
				right--;
				left++;
			}
		}
		// 출력
		System.out.println(answer_left + " " + answer_right);
	}
}
