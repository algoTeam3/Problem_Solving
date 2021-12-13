import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_8382 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// (x1, y1), (x2, y2) 입력받기 완료
			
			int a = Math.abs(x1 - x2);
			int b = Math.abs(y1 - y2);
			// 규칙 - 짝수일 때는 둘 중 큰 값 * 2, 홀수일 때는 둘 중 큰 값 * 2 - 1
			if ((a + b) % 2 == 0) ans = Math.max(a, b) * 2;
			else ans = Math.max(a, b) * 2 - 1;
			System.out.println("#" + t + " " + ans);
		}
	}
}
/*
3
0 0 1 0
-1 -1 0 0
0 0 0 2
*/