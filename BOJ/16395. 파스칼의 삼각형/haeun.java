import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16395_파스칼의삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());	// n번째 행
		int k = Integer.parseInt(st.nextToken());	// k번째 수
		int[][] arr = new int[n+1][n+1];
		
		arr[0][0] = 1;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < i+1; j++) {
				if (i == 0 || i == j) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		// 출력
		System.out.println(arr[n][k]);
	}
}
