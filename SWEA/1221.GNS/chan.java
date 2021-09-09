import java.util.*;
import java.io.*;
 
class chan {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            System.out.println(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            String[] input = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
            int[] cnt = new int[10];
            for (int i = 0; i < len; i++) {
                String index = st.nextToken();
                for (int j = 0; j < input.length; j++) {
                    if (index.equals(input[j])) {
                        cnt[j]++;
                        break;
                    }
                }
            }
            for (int i = 0; i < cnt.length; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    System.out.print(input[i] + " ");   
                }
            }
            System.out.println();
        }
    }
}
