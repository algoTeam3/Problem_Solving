import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		  // 테스트케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			String control = br.readLine();				      // 컨트롤 프로그램
			int direction = 0;							            // 북쪽부터 시계 방향
			int[] pos = {0, 0};						            	// 현재 위치
			int minX = 0, minY = 0, maxX = 0, maxY = 0; // 직사각형 위치 구하기
			
			for (int i = 0; i < control.length(); i++) {
				switch (control.charAt(i)) {
					case 'F' :
						pos[0] += dx[direction];
						pos[1] += dy[direction];
						break;
					case 'B' :
						pos[0] -= dx[direction];
						pos[1] -= dy[direction];
						break;
					case 'L' :
						direction--;
						break;
					case 'R' :
						direction++;
						break;
				}
				if (direction == 4) direction = 0;
				else if (direction == -1) direction = 3;
				
				minX = Math.min(minX, pos[0]);
				minY = Math.min(minY, pos[1]);
				maxX = Math.max(maxX, pos[0]);
				maxY = Math.max(maxY, pos[1]);
			}
			/// 출력
			System.out.println((maxX - minX) * (maxY - minY));
		}
	}
}
