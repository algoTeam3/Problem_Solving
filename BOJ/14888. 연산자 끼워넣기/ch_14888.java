import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] numbers;
    static ArrayList<Character> opers = new ArrayList<>();
    static char[] selected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selected = new char[N - 1];
        visited = new boolean[N - 1];

        // 숫자 배열 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 부호 값넣기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int j = 0; j < n; j++) opers.add('+');
        n = Integer.parseInt(st.nextToken());
        for (int j = 0; j < n; j++) opers.add('-');
        n = Integer.parseInt(st.nextToken());
        for (int j = 0; j < n; j++) opers.add('*');
        n = Integer.parseInt(st.nextToken());
        for (int j = 0; j < n; j++) opers.add('/') ;

        solve(0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int cnt) {
        if (cnt == N - 1){
            int sum = cal();
            if (max < sum) max = sum;
            if (min > sum) min = sum;
            return;
        }

        for (int i = 0; i < N - 1; i++) {   // 순열
            if (visited[i]) continue;
            selected[cnt] = opers.get(i);

            visited[i] = true;
            solve(cnt + 1);
            visited[i] = false;
        }

    }

    private static int cal() { // 첫 숫자를 넣고 부호 + 다음 숫자 계산
        int sum = numbers[0];
        for (int i = 0; i < N - 1; i++) {
            switch (selected[i]){
                case '+' :
                    sum += numbers[i + 1];
                    break;
                case '-' :
                    sum -= numbers[i + 1];
                    break;
                case '*' :
                    sum *= numbers[i + 1];
                    break;
                case '/' :
                    if (sum < 0){
                        sum = (sum * (-1)) / numbers[i + 1];
                        sum = sum * (-1);
                    }else  sum /= numbers[i + 1];
                    break;
            }
        }
        return sum;
    }
}
