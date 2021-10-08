import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 정점의 개수
		int[][] arr = new int[N][N];				// 인접 행렬
		
		// 인접 행렬 입력 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		// 플로이드-와샬
		// 경유지
		for (int k = 0; k < N; k++) {
			// 출발
			for (int i = 0; i < N; i++) {
				// 도착
				for (int j = 0; j < N; j++) {
					// 경로가 있다면
					if (arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" "); 
			}
			System.out.println();
		}
	}
}
