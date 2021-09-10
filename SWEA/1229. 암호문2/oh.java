import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Expert1229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                String commend = st.nextToken();
                switch (commend){
                    case "I":
                        int x1 = Integer.parseInt(st.nextToken());
                        int y1 = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y1; j++) {
                            arr.add(x1+j,Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case "D":
                        int x2 = Integer.parseInt(st.nextToken());
                        int y2 = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y2; j++) {
                            arr.remove(x2);
                        }
                        break;
                }

            }
            System.out.print("#"+test_case+" ");
            for (int i = 0; i < 10; i++) {
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
        }
    }
}
