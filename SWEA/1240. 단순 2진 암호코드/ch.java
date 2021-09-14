package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 검증 코드 : 홀수 자리의 합 * 3 + 짝수 자리의 합 + 검증코드 = 10의 배수
 */
public class SWEA_D3_1240_단순2진암호코드 {
    static String[] numbers = {"0001101","0011001", "0010011", "0111101", "0100011",
                                "0110001", "0101111", "0111011", "0110111", "0001011"};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int ans = 0;
            String code = "";
            String decode = "";

            // 배열 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                char[] num = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = num[j];
                }
            }

            // 코드 분별하기
            int idx = 0;
            outer :  for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '1') {
                        idx = j;    // 1의 마지막 위치 찾기
                    }
                }

                if (idx == 0) continue; // 1이 없다면 다음 줄

                for (int j = idx - 55; j <= idx; j++) {   // 56개의 코드줄 추출
                    code += map[i][j];
                }
                
                // 2진 코드 10진수로
                int start = 0, end = 7;
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < numbers.length; k++) {
                        if (code.substring(start + (7 * j), end + (7 * j)).equals(numbers[k].toString())) {
                            decode += k;
                        }
                    }
                }

                int even = 0, odd = 0, sum = 0;
                for (int j = 0; j <decode.length(); j++) {
                    if (j % 2 == 1 ) {
                        even += decode.charAt(j) - '0';
                    }else { // 홀수 자리일때
                        odd += decode.charAt(j) - '0';
                    }
                }
                sum = odd * 3 + even;   // 홀수 * 3 + 짝수 + 검증코드
                // 10의 배수이면 합계, 아니면 0 출력
                if (sum % 10 == 0) for (int j = 0; j < decode.length(); j++) ans += decode.charAt(j) - '0';
                else ans = 0;

                break outer;    // 코드 해석 완료되면 탈출
            }
            System.out.println("#" + t + " " + ans);
        }
    }

}
