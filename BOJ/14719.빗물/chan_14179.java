import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_14179 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int height = Integer.parseInt(st.nextToken());	// 세로길이
		int W = Integer.parseInt(st.nextToken());	// 가로길이
		st = new StringTokenizer(br.readLine(), " ");
		int[] blocks = new int[W];
		for (int w = 0; w < W; w++) {
			blocks[w] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		
		// 제일 처음과 제일 마지막 블록을 제외한 블록을 기준으로 탐색
		for (int w = 1; w < W - 1; w++) {
			int leftWall = blocks[w];
			int rightWall = blocks[w];
			int minHeight = height;
			
			// 현재 블록의 왼쪽에 있는 블록들 중 가장 높은 블록 탐색
			for (int i = 0; i < w; i++) {
				if (leftWall < blocks[i]) leftWall = blocks[i];
			}

			// 현재 블록의 오른쪽에 있는 블록들 중 가장 높은 블록 탐색
			for (int i = w + 1; i < W; i++) {
				if (rightWall < blocks[i]) rightWall = blocks[i];
			}
			
			// 왼쪽에서 가장 높은 블록과 오른쪽에서 가장 높은 블록 중 더 낮은 블록의 높이 저장
			minHeight = (leftWall > rightWall) ? rightWall : leftWall;
			
			// 더 낮은 높이의 블록에서 현재 블록의 높이를 뺀 만큼 빗물이 고인다.
			answer += (minHeight - blocks[w]);
			
		}
		 
		System.out.println(answer);
		
	}

}
