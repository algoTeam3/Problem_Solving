package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_6603_Lotto {
    static int N;
    static int[] isSelected;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            numbers = new int[N];
            isSelected = new int[6];
            if (N == 0) break;
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            System.out.println();
        }
    }

    private static void comb(int cnt, int start) {
        if(cnt == 6) {
            for (int n :
                    isSelected) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            isSelected[cnt] = numbers[i];
            comb(cnt + 1, i + 1);
        }
    }
}
