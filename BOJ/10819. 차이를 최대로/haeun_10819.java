import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {
	
	public static int N, max;
	public static int[] A, arr;
	public static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// N개의 정수
		A = new int[N];							// 입력받는 배열
		arr = new int[N];
		checked = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 배열 채우기
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// 최댓값을 최소로 초기화
		max = Integer.MIN_VALUE;
		
		perm(0);
		// 출력
		System.out.println(max);
	}
	
	// 순열
	public static void perm(int num) {
		// 기저조건
		if (num == N) {
			// 주어진 식대로 계산
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(arr[i] - arr[i+1]);
			}
			// 최댓값 갱신
			if (sum > max) max = sum;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (checked[i]) continue;
			arr[num] = A[i];
			checked[i] = true;
			perm(num + 1);
			checked[i] = false;
		}
	}
}
