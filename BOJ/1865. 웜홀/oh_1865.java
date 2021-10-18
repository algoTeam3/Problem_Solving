import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
*
*음수 사이클 확인하는 문제
*
*/
public class oh_1865 {
    static final int INF=987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =Integer.parseInt(st.nextToken());
            int M =Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            //map생성
            int[][] map = new int[N + 1][N + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(k==j)continue;
                    map[j][k]=INF;
                }
            }

            // 도로 입력
            for (int j = 0; j < M; j++) {
                st=new StringTokenizer(br.readLine());
                int from =Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                int cost =Integer.parseInt(st.nextToken());

                map[from][to]= Math.min(map[from][to],cost);
                map[to][from]= Math.min(map[to][from],cost);

            }
            // 웜홀 입력
            for (int j = 0; j < W; j++) {
                st=new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                map[from][to]=Math.min(map[from][to],-1*cost);
            }
            //플로이드
            for (int k = 1; k <= N; k++) {
                for (int j = 1; j <= N; j++) {
                    for (int l = 1; l <= N; l++) {
                        map[j][l]=Math.min(map[j][l],map[j][k]+map[k][l]);
                    }
                }
            }
            // 출력
            boolean flag =true;
            for (int j = 1; j <= N; j++) {
             //자신에게로 오는 경로값이 음수면 플로이드로 구한 경로가 최소값이라는 것을 보장하지 못한다
             if(map[j][j]<0){
                 flag=false;
                 break;
             }
            }
            if(flag){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
