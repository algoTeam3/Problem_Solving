import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int ans = 0;
			int findLen = Integer.parseInt(br.readLine());
			char[][] board = new char[8][8];
			for (int i = 0; i < 8; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < 8; j++) {
					board[i][j] = line[j];
				}
			}
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - findLen + 1; j++) {
					int cnt = 1;
					while(cnt <= findLen / 2) {
						if (board[i][j + cnt - 1] != board[i][j + findLen - cnt]) break;
						if (cnt == findLen/2) ans++;
						cnt++;
					}
				}
			}
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - findLen + 1; i++) {
					int cnt = 1;
					while(cnt <= findLen / 2) {
						if (board[i + cnt - 1][j] != board[i + findLen - cnt][j]) break;
						if (cnt == findLen/2) ans++;
						cnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
