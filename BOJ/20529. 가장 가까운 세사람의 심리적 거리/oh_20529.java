

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 */
public class oh_20529 {
    static int p;
    static String mbti[];
    static boolean visit[];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            p = Integer.parseInt(br.readLine());
            mbti = new String[p];
            visit = new boolean[p];

            //입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mbti.length; j++) {
                mbti[j] = st.nextToken();

            }
            if(p>32){
                System.out.println(0);
            }else{
                min = Integer.MAX_VALUE;
                Comb(0);
                System.out.println(min);
            }
        }

    }

    private static void Comb(int cnt) {
        if (cnt == 3) {
            cal();
            return;
        }
        for (int i = 0; i < mbti.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            Comb(cnt + 1);
            visit[i] = false;
        }
    }

    private static void cal() {
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                str.add(mbti[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (str.get(0).charAt(i) != str.get(1).charAt(i)) count++;
            if (str.get(0).charAt(i) != str.get(2).charAt(i)) count++;
            if (str.get(1).charAt(i) != str.get(2).charAt(i)) count++;
        }
        min = Math.min(min, count);
    }
}
