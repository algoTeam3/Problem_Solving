
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_16064_floyd {
    static int N,M;
    static int[][] map;
   
    static final int INF = -987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
       map= new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i==j)map[i][j]=0;
                map[i][j]=INF;
            }
        }

        //get input v
        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to =Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

           map[from][to]=Math.max(map[from][to],cost);
        }
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {

                    map[i][j]= Math.max(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        int max =Integer.MIN_VALUE;
        for (int[] ints : map) {
            for (int i : ints) {

                max= Math.max(max,i);
            }
        }
        System.out.println(max);
    }


}
