import java.util.Scanner;

public class SW_D3_10505_소득불균형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 						// 테스트 케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 					// 소득의 수
			int avg = 0;							// 소득의 평균을 구할 avg 변수
			int cnt = 0;							// 평균 이하의 소득을 가진 사람들의 수
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				avg += arr[i];						// 먼저, 합계 구하기
			}
			
			avg /= N;								// 합계를 전체 소득의 수로 나눠서 평균 구하기		
			for (int i = 0; i < N; i++) {	
				if (arr[i] <= avg) cnt++;			// 평균보다 해당 arr[i]값이 이하면 cnt+1
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();
	}
}
