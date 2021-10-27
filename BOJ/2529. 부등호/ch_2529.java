import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * BOJ_2529_부등호
 *
 */
public class ch_2529 {
    static int[] selected;
    static boolean[] visited;
    static char[] oper;
    static int k;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        oper = new char[k];         // 연산자 배열
        visited = new boolean[10];  // 방문 체크
        selected = new int[k + 1];  // 선택 배열

        // 부등호 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            oper[i] = st.nextToken().charAt(0);
        }


        solve(0);

        System.out.println(max);
        // 0 처리
        String str = Long.toString(min);
        if (str.length() < k + 1) System.out.println('0' + str);
        else System.out.println(min);
    }

    private static void solve(int cnt) {
        if (cnt == k + 1) {
            if (calOper()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < selected.length; i++) {
                    sb.append(selected[i]);
                }
                long num = Long.parseLong(sb.toString());
                if(num > max) max = num;
                if(num < min) min = num;
                return;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            selected[cnt] = i;
            visited[i] = true;
            solve(cnt + 1);
            visited[i] = false;
        }

    }

    // 부등호 처리
    private static boolean calOper() {
        for (int i = 0; i < oper.length; i++) {
            switch (oper[i]){
                case '>' :
                    if (selected[i] > selected[i + 1]) {
                        continue;
                    }
                    else return false;

                case '<' :
                    if (selected[i] < selected[i + 1]) continue;
                    else return false;
            }
        }
        return true;
    }
}
