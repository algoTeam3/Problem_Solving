import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
	
	public static int n, max;
	public static boolean[] checked;
	public static ArrayList<Node> list[];
	
	public static class Node{
	    int num;
	    int weight;
	    
	    Node(int num, int weight){
	        this.num = num;
	        this.weight = weight;
	    }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());	// 노드의 개수
		 list = new ArrayList[n+1];
		 for (int i = 1; i <= n; i++) list[i] = new ArrayList<Node>();
		 
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());	// 부모 노드
			int end = Integer.parseInt(st.nextToken());		// 자식 노드
			int weight = Integer.parseInt(st.nextToken());	// 간선의 가중치
	        list[end].add(new Node(start, weight));
	        list[start].add(new Node(end, weight));
		}
		
		max = 0;
		
		for (int i = 1; i <= n; i++) {
			checked = new boolean[n+1];
			checked[i] = true;
			dfs(i, 0);
		}
		
        // 출력
        System.out.println(max);
    }
	
	// dfs
    public static void dfs(int num, int sum){
        for (Node node : list[num]) {
        	// 방문 안함
            if (!checked[node.num]){
            	checked[node.num] = true;
                dfs(node.num, sum + node.weight);
            }
        }
        
        // 최댓값 갱신
        if (max < sum) max = sum;
    }
}
