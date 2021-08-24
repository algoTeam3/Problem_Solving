package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 새샘이의 7-3-5 게임
 * 서로 다른 7개의 정수 중에서 3개의 정수르 골라 합을 구해서 수를 만들기
 * 5번쨰 큰 수 출력
 */
public class SWEA_D3_5948 {
    static int[] arr;
    static int[] selected;
    static HashSet<Integer> answer = new HashSet<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int ans = 0;
            arr = new int[7];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            selected = new int[4];
            comb(0, 0);

            List anslist = new ArrayList(answer);   // HashSet 정렬을 위한 ArrayList변환
            Collections.sort(anslist);
            System.out.println("#" + t + " " + anslist.get(answer.size()-5));
            answer.clear();
        }
    }

    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += selected[i];
            }
            answer.add(sum);
            return;
        }

        for (int i = start; i < 7; i++) {
            selected[cnt] = arr[i];
            comb(cnt + 1, i + 1);
        }
    }
}
