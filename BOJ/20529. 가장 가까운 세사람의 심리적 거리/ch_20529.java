import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_20529 {
    static int N, min;
    static String[] person;
    static String[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            person = new String[N];
            selected = new String[3];
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                person[i] = st.nextToken();
            }

            if (N > 32) {
                System.out.println(0);
            }else{
                solve(0, 0);
                System.out.println(min);
            }
        }
    }

    private static void solve(int cnt, int start) {
        if (cnt == 3){
            calDist();
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = person[i];
            solve(cnt + 1, i + 1);
        }
    }

    private static void calDist() {
        int dis = 0;
        for (int i = 0; i < 4; i++) {
            if(selected[0].charAt(i) != selected[1].charAt(i)) dis++;
            if(selected[0].charAt(i) != selected[2].charAt(i)) dis++;
            if(selected[1].charAt(i) != selected[2].charAt(i)) dis++;
        }

        if(dis < min) min = dis;
    }
}
