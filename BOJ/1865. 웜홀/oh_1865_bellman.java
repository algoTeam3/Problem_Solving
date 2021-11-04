

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1865.웜홀
 * 
 */
public class oh_1865_bellman {
    static int N,M,W;
    static int[] visit;
    static ArrayList<ArrayList<node>> arr;
    static final int INF= 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N =Integer.parseInt(st.nextToken());//노드
            M =Integer.parseInt(st.nextToken());//도로 양방향
            W =Integer.parseInt(st.nextToken());//웜홀 단방향

            //리스트 생성
            arr= new ArrayList<>();
            for (int j = 0; j < N+1; j++) {
                arr.add(new ArrayList<>());
            }
            //도로 넣기
            for (int j = 0; j < M; j++) {
                st= new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to =Integer.parseInt(st.nextToken());
                int cost =Integer.parseInt(st.nextToken());

                arr.get(from).add(new node(to,cost));
                arr.get(to).add(new node(from,cost));
            }
            //웜홀 넣기
            for (int j = 0; j < W; j++) {
                st=new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to =Integer.parseInt(st.nextToken());
                int cost=-1*Integer.parseInt(st.nextToken());

                arr.get(from).add(new node(to,cost));
            }
            visit = new int[N+1];
           boolean flag = false;
            for (int j = 1; j < N+1; j++) {
                if(bellman(j)){
                    flag = true;
                    System.out.println("YES");
                    break;
                }
            }
            if(!flag) System.out.println("NO");
        }
        
    }

    //벨만포드
    private static boolean bellman(int start) {
        boolean flag =false;
        Arrays.fill(visit,INF);
        visit[start]=0;
        for (int j = 1; j < N+1; j++) {
            flag = false;

            for (int i = 1; i < N+1; i++) {
                for(node n:arr.get(i)){
                    if(visit[n.to]>visit[i]+n.value){
                        visit[n.to]=visit[i]+n.value;
                        flag = true;
                    }
                }
            }
            if(!flag) break;
        }
        //음수 사이클 확인
        if(flag){
            for (int i = 1; i < N+1; i++) {
                for (node n : arr.get(i)) {
                    if(visit[n.to]>visit[i]+n.value){
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
