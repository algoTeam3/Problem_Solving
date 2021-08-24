package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 세트의 카드
 * 1~N, 1~M번 카드 구성
 * 한장씩 골라 더한 값중 확률이 가장 높은 숫자 구하기
 */
public class SWEA_D3_7102_준홍이의카드놀이 {
    static int N, M;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            answer = new int[N * M];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    answer[i + j]++;
                }
            }
            for (int i = 0; i < answer.length; i++) {
                max = Math.max(max, answer[i]);
            }
            System.out.print("#" + t + " " );
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == max ) System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
