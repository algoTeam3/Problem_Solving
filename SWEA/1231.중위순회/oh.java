import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1231 {
    static String[] arr;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1231.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int r = Integer.parseInt(br.readLine());
            arr = new String[r + 1];
            check = new boolean[r + 1];
            sb = new StringBuilder();

            //배열에 담기
            for (int i = 1; i < r + 1; i++) {
                arr[i] = br.readLine();
            }
            search(1);
            System.out.println("#" + test_case + " " + sb);
        }


    }

    static void search(int node) {
        String[] ch = new String[4];
        StringTokenizer st = new StringTokenizer(arr[node]);
        int num = 0;
        while (st.hasMoreTokens()) {
            ch[num++] = st.nextToken();
        }
        if (ch[2] != null) {//왼
            search(Integer.parseInt(ch[2]));
        }
        sb.append(ch[1]);
        if (ch[3] != null) {//오
            search(Integer.parseInt(ch[3]));
        }


    }


}
