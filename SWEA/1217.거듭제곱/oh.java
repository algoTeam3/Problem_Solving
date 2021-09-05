import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int P=Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            System.out.println("#"+P+" "+power(N,M));
        }
    }
    static int power(int n,int m){
        if(m==1) return n;
        return n*power(n,m-1);
    }
}
