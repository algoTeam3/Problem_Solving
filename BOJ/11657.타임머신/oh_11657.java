import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 11657.타임머신
 *
 *
 */
public class oh_11657 {
    static int N,M;
    static ArrayList<ArrayList<node>> arr;
    static long[] visit;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //리스트 생성
        arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            arr.add(new ArrayList<>());
        }

        //입력받기
        for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());
           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           int cost =  Integer.parseInt(st.nextToken());
           
           arr.get(from).add(new node(to,cost));
        }
        visit = new long[N+1];
        if(bellman()){
            System.out.println(-1);

        }else{

            for(int i =2; i<N+1;i++) {
                if(visit[i]==INF){
                    System.out.println(-1);
                }else{
                    System.out.println(visit[i]);
                }
            }
        }
    }

    private static boolean bellman() {
        boolean flag = false;
        Arrays.fill(visit,INF);
        visit[1]=0;

        for (int i = 1; i < N; i++) {
            flag = false;

            for (int j = 1; j < N+1; j++) {
                for (node node : arr.get(j)) {
                    if(visit[j]==INF) break;
                    if(visit[node.to]>visit[j]+node.value){
                        visit[node.to]=visit[j]+node.value;
                        flag = true;
                    }
                }
            }
            if(!flag)break;

        }
        //음수 사이클 확인
        if(flag){
            for (int i = 1; i < N+1; i++) {
                for (node node : arr.get(i)) {
                    if(visit[i]==INF) break;
                    if(visit[node.to]>visit[i]+node.value){
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
class node {
    int to;
    int value;

    node(int to, int value) {
        this.to = to;
        this.value = value;
    }

}
