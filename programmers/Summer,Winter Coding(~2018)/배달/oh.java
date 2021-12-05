package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @packageName : programmers
 * @fileName : 배달
 * @date : 2021. 12. 05.
 * @language : JAVA
 * @classification : graph
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:00
 * @submissions : 1
 * @description
 *
 **/
public class 배달 {
    static int[] visit;
    static ArrayList<ArrayList<node>> arr;
    static final int INF =987654321;

    public static void main(String[] args) {
        //{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}
        int answer = solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3);
        System.out.println(answer);
    }
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        visit = new int[N+1];
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            visit[i]=INF;
        }
        
        for (int i = 0; i < road.length; i++) {
            int from =road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            
            arr.get(from).add(new node(to,cost));
            arr.get(to).add(new node(from,cost));
        }
        //다익스트라
        Dij();

        for (int i : visit) {
            if(i==INF)continue;
            if(i<=K)answer++;
        }
        return answer;
    }

    private static void Dij() {
        PriorityQueue<node> que = new PriorityQueue<>();
        que.add(new node(1,0));
        visit[1]=0;
        while (!que.isEmpty()){
            node z = que.poll();

            if(z.value>visit[z.to])continue;
            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node n = arr.get(z.to).get(i);
                if(visit[n.to]>visit[z.to]+n.value){
                    visit[n.to]=visit[z.to]+n.value;
                    que.add(new node(n.to,visit[n.to]));
                }
            }
        }
    }
}
class node implements Comparable<node> {
    int to;
    int value;

    public node(int to, int value) {
        this.to = to;
        this.value = value;
    }


    @Override
    public int compareTo(node node) {
        return this.value-node.value;
    }
}
