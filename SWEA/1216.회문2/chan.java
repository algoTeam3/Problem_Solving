import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class chan {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			char[][] map = new char[100][100];
			int ans = 0;
			
			// 테스트케이스 입력받기
			for (int i = 0; i < 100; i++) {
				char[] data = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = data[j];
				}
			}
			
			// 행 탐색
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 99; j++) {
					// 원소 [i][j] 부터 길이가 2,3,4,... 로 늘려가며 차례로 비교하여 회문 찾기
					for (int k = j + 1; k < 100; k++) {
						int compare = (k - j + 1) / 2; // 몇 번 비교하는지
						int cnt = 0;
						while(compare > 0) {
							if (map[i][j + cnt] != map[i][k - cnt]) break;
							// 마지막 비교까지 했으면 회문이므로 최대 길이인지 확인
							if (compare - 1 == 0) {
								ans = Math.max(ans, k - j + 1);
							}
							compare--;
							cnt++;
						}
					}
				}
			}
			
			// 열 탐색도 행 탐색과 동일
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 99; j++) {
					for (int k = j + 1; k < 100; k++) {
						int compare = (k - j + 1) / 2; // 몇 번 비교하는지
						int cnt = 0;
						while(compare > 0) {
							if (map[j + cnt][i] != map[k - cnt][i]) break;
							if (compare - 1 == 0) {
								ans = Math.max(ans, k - j + 1);
							}
							compare--;
							cnt++;
						}
						
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

}
