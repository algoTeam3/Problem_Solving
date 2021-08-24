package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D3_회문2 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10 ; t++) {
            br.readLine();  // 테스트케이스번호
            int max = Integer.MIN_VALUE;
            map = new char[100][100];
            for (int i = 0; i < 100; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int result = 1;
            for (int len = 100; len > 0 ; len--) {
                if (result > 1) break;
                //가로
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100 - len + 1; j++) {
                        int flag = 0;
                        for (int k = 0; k < len / 2; k++) {
                            if (map[i][j + k] != map[i][j + len - k - 1]) {
                                flag = -1;
                            }
                        }
                        if (flag == 0)  result = len;
                    }
                }
                //세로
                for (int i = 0; i < 100 - len + 1; i++) {
                    for (int j = 0; j < 100; j++) {
                        int flag = 0;
                        for (int k = 0; k < len / 2; k++) {
                            if (map[i + k][j] != map[i + len - k - 1][j]) {
                                flag = -1;
                            }
                        }
                        if (flag == 0)  result = len;
                    }
                }

            }
            System.out.println("#" + t + " " + result);
        }
    }
}
