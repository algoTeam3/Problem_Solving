

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 16922.로마 숫자 만들기
 * <p>
 * 중복조합
 */
public class oh_16922 {
    static int N, R, count;
    static boolean[] check;
    static int[] ch;
    static int[] input;
    static Set set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        N = 4;
        count = 0;
        check = new boolean[N];
        ch = new int[]{1,5,10,50};
        input = new int[R];
        set= new HashSet();
        Dfs(0, 0);
        System.out.println(set.size());
    }

    private static void Dfs(int cnt, int start) {
        if (cnt == R) {
            int sum=0;
            for (int c : input) {

                sum+=c;
            }
            set.add(sum);

            return;
        }
        for (int i = start; i < check.length; i++) {


            check[i] = true;
            input[cnt] = ch[i];
            Dfs(cnt + 1, i);
            check[i] = false;


        }
    }
}
