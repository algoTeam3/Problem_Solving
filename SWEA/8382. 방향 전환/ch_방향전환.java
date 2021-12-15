import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_방향전환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int x = Math.abs(x1 - x2);
            int y = Math.abs(y1 - y2);
            if ((x + y) % 2 == 0){
                ans = Math.max(x, y) * 2;
            }else {
                ans = Math.max(x, y) * 2 - 1;
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
