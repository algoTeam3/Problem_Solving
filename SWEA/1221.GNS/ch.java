package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1221_GNS {
    static int[] numarr;
    static StringBuilder sb;
    static String[] numstr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};  // 0 ~ 9 인덱스값에 각 문자열 초기화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
         sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.setLength(0);
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int len = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            numarr = new int[10]; // 각 문자열 수를 세기 위한 배열 선언
            for (int i = 0; i < len; i++) {
                String str = st.nextToken();
                stn(str);
            }
            
            // 정렬된 값을출력하기 위해 ZRO부터 크기만큼 출력한다
            print();

            System.out.println("#" + t + " " + sb);
        }
    }

    private static void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numarr[i]; j++) {
                sb.append(numstr[i]+" "); // "ZRO ~ "NIN"
            }
        }
    }

    private static void stn(String str) {   // 문자열 세기
        switch (str) {
            case "ZRO" : numarr[0]++;
            break;
            case "ONE" : numarr[1]++;
                break;
            case "TWO" : numarr[2]++;
                break;
            case "THR" : numarr[3]++;
                break;
            case "FOR" : numarr[4]++;
                break;
            case "FIV" : numarr[5]++;
                break;
            case "SIX" : numarr[6]++;
                break;
            case "SVN" : numarr[7]++;
                break;
            case "EGT" : numarr[8]++;
                break;
            case "NIN" : numarr[9]++;
                break;
        }
    }
}
