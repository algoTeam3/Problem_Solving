import java.util.Scanner;

public class SW_D4_1211_Ladder2 {
	private static int[] dx = {0, 1, 0, 1};
	private static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			String T = sc.next();
			// 사다리 배열
			int[][] arr = new int[100][100];
			// 최소 루트
			int min = Integer.MAX_VALUE;
			// num번째 출발점
			int num = 0;
			
			// 사다리 만들기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 출발점 순회
			for (int j = 0; j < 100; j++) {
				// 사다리가 있을 시
				if (arr[0][j] == 1) {
					int cnt = 1;
					int d = 0;
					int nx = 0;
					int ny = j;
					
					// 방향을 돌리기 위한 반복문
					outer: while (true) {
						// 바닥까지 가기 위한 반복문
						while (true) {
							nx += dx[d];
							ny += dy[d];
							// 범위를 벗어나거나 사다리가 아닐 시에 반복문 탈출
							if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || arr[nx][ny] == 0) {
								break;
							}
							// 여기까지 왔으면 경로+1
							cnt++;
							// 만일 아래로 내려가는 도중인데
							if (d == 1 || d == 3) {
								// 왼쪽에 사다리가 있다면, 왼쪽으로 이동
								if (ny-1 >= 0 && arr[nx][ny-1] == 1) {
									d = 0;
									continue;
								// 오른쪽에 사다리가 있다면, 오른쪽으로 이동
								} else if (ny+1 < 100 && arr[nx][ny+1] == 1) {
									d = 2;
									continue;
								}
							}
							// 바닥에 도착하면 멈춤
							if (nx == 99) break outer;
						}
						
						// 이동했던 값 이전으로 되돌아가기
						nx -= dx[d];
						ny -= dy[d];
						// 방향 전환
						d++;
						if (d >= 4) d = 0;
					}
					
					// 만일 기존 min보다 현재 cnt가 더 작다면
					if (cnt < min) {
						// 해당 cnt와 출발점 j 저장
						min = cnt;
						num = j;
					}
				}
			}
			// 출력
			System.out.printf("#%s %d\n", T, num);
		}
		sc.close();
	}
}
