import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	
	public static int N, max, min;
	public static int[] num, cal;

	// +, -, *, /
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 수의 개수
		num = new int[N];						// 수
		cal = new int[4];						// 연산자의 수
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		// 수 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		// 연산자 개수 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) cal[i] = Integer.parseInt(st.nextToken());
	
		dfs(1, num[0]);
		// 출력
		System.out.print(max + "\n" + min);
	}
	
	// dfs
	public static void dfs(int n, int result) {
		// 기저조건
		if (n == N) {
			if (result < min) min = result;
			if (result > max) max = result;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			// 연산자가 존재한다면
			if (cal[i] != 0) {
				cal[i]--;
				
				// 계산
				if (i == 0)	dfs(n+1, result + num[n]); // +
				if (i == 1) dfs(n+1, result - num[n]); // -
				if (i == 2) dfs(n+1, result * num[n]); // *
				if (i == 3) dfs(n+1, result / num[n]); // /
				
				cal[i]++;
			}
		}
	}
}
