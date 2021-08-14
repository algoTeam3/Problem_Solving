import java.util.Scanner;

public class SW_D3_2817_부분수열의합 {

	private static int N, K, total;
	private static int[] arr;
	private static boolean[] checked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();					// 테스트 케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();					// N개의 정수
			K = sc.nextInt();					// 목표 합
			arr = new int[N];					// 수열
			checked = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			total = 0;
			solve(0);
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
		sc.close();
	}
	
	// 부분 수열의 합 구하기
	private static void solve(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (checked[i]) sum += arr[i];
			}
			if (sum == K) total++;
			return;
		}
		checked[cnt] = true;
		solve(cnt+1);
		checked[cnt] = false;
		solve(cnt+1);
	}
}
