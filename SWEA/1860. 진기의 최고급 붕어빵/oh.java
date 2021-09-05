import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Expert1860 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1860.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int bread = 0;
            String answer = "Possible";
            int[] people = new int[11112];
            st = new StringTokenizer(br.readLine());
          //i초에 사람이 몇명오는지 세기
            for (int i = 0; i < N; i++) {
                people[Integer.parseInt(st.nextToken())]++;
            }

            for (int i = 0; i < people.length; i++) {
              //빵이 없으면 끝
                if(bread<0){
                    answer="Impossible";
                    break;
                }
              //M초만큼 빵 K개 증가
                if(i!=0&&i%M==0){
                    bread+=K;
                }
              //사람 수 만큼 빵 감소
                bread-=people[i];
            }


            System.out.println("#"+test_case+" "+answer);
        }
    }
}
