package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D3_1234_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        ArrayList<Character> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.setLength(0);
            al.clear();
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int i = 0; i < len; i++) {
                al.add(str.charAt(i));
            }

            int cnt = 0;
            while (true) {
                if (cnt == al.size() - 1) break;
                if (al.get(cnt) == al.get(cnt+1)) {
                    al.remove(cnt);
                    al.remove(cnt);
                    cnt = 0;
                }else {
                    cnt++;
                }

            }
            for (int i = 0; i < al.size(); i++) {
                sb.append(al.get(i));
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}
