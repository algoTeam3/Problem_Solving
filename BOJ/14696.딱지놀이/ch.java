package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 별 > 동그라미 > 네모 > 세모 > 무승부
 * 4       3       2      1     D
 */
public class BOJ_B1_14696_딱지놀이 {
    static int[] setA;
    static int[] setB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());   // 총 라운드 수 ( 1 <= T <= 1000)
        for (int t = 0; t < T; t++) {
            char answer = 'D';
            setA = new int[5];  // 0 제외 1~4
            setB = new int[5];

            // A 어린이 덱 세팅
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int i = 0; i < size ; i++) {
                setA[Integer.parseInt(st.nextToken())]++;
            }
            // B 어린이 덱 세팅
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            for (int i = 0; i < size; i++) {
                setB[Integer.parseInt(st.nextToken())]++;
            }

            // 값 비교
            for (int i = 4; i > 0; i--) {
                answer = compare(setA[i], setB[i]);
                if( answer != 'D') break;
                continue;
            }
            System.out.println(answer);
        }
    }

    private static char compare(int A, int B) {
        if (A - B > 0) return 'A';
        else if(A - B < 0) return 'B';
        else return 'D';
    }
}
