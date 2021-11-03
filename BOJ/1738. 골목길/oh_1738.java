package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class oh_1738 {
    static int N,M;
    static ArrayList<ArrayList<node>> arr;
    static int visit[];
    static final int INF = -987654321;
    static ArrayList<ArrayList<Integer>> order;
    static ArrayList<Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        //리스트생성
        arr = new ArrayList<>();
        order = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
            order.add(new ArrayList<>());
        }

        //입력값 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            arr.get(from).add(new node(to,cost));
        }
        map = new ArrayList<>();
        visit = new int[N+1];
        int max = Integer.MIN_VALUE;
        if(bellman()){
            for (int i = 2; i < N+1 ; i++) {
                max =Math.max(visit[i],max);
            }
        }else{
            System.out.println(-1);
            return;
        }
        for (ArrayList<Integer> integers : order) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
        }
        System.out.println(max);
    }

    private static boolean bellman() {
        Arrays.fill(visit,INF);
        visit[1]=0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            flag = false;

            for (int j = 1; j < N+1; j++) {
                for (node node : arr.get(j)) {
                    if(visit[node.to]<visit[j]+node.value){
                        visit[node.to]=visit[j]+node.value;

                        flag = true;
                    }
                }
            }
        if(!flag)break;
        }
        if(flag){
            for (int i = 0; i < N + 1; i++) {
                for (node node : arr.get(i)) {
                    if(visit[node.to]<visit[i]+node.value){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
