import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D4_8382_방향전환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 출발
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 도착
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 거리 구하기
			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);
			
			// 이동 횟수
			int answer = 0;
			
			// 짝수일 때
			if ((x + y) % 2 == 0) answer = Math.max(x, y) * 2;
			// 홀수일 때
			else answer = Math.max(x, y) * 2 - 1;
			
			// 출력
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
