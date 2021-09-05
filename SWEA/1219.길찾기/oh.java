import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1219 {
    static int[] ints1;
    static int[] ints2;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());//1
        int R = Integer.parseInt(st.nextToken());//16
            st= new StringTokenizer(br.readLine());
            ints1 = new int[101];
            ints2 = new int[101];
            flag =false;
        for (int z = 0; z < R; z++) {
            int node =Integer.parseInt(st.nextToken());//인덱스
            int next =Integer.parseInt(st.nextToken());//값

            if(ints1[node]==0){
                ints1[node]=next;
            }else{
                ints2[node]=next;
            }

        }
            search(ints1[0]);
            search(ints2[0]);
            if(flag){
                System.out.println("#"+T+" "+1);
            }else{
                System.out.println("#"+T+" "+0);
            }
        }
    }
    static void search(int cnt){
        if(cnt==0)return;
        if(cnt==99){
           flag= true;
            return;
        }
        search(ints1[cnt]);
        search(ints2[cnt]);
    }

}
