import java.util.Scanner;

public class SW_D3_1217_거듭제곱 {
	private static int N, M, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();	// 테스트케이스 번호
			
			N = sc.nextInt();		// N의
			M = sc.nextInt();		// M 거듭제곱
			result = 1;
			
			solve(0);
			// 출력
			System.out.printf("#%d %d\n", T, result);
		}
		sc.close();
	}
	
	// 거듭제곱
	private static void solve(int cnt) {
		if (cnt == M) return;
		result *= N;
		solve(cnt+1);
	}
}
