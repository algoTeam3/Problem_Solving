import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Expert1238 {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] visit;
    static ArrayList<Integer[]> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());
            visit = new int[101];
            answer = new ArrayList<>();
            //인접 리스트 생성
            arr = new ArrayList<>();
            //최대 수 만큼 넣기
            for (int i = 0; i < 101; i++) {
                arr.add(new ArrayList<>());
            }
            //열 넣기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());


                arr.get(from).add(to);
            }
            BFS(startNode);
            int max= Integer.MIN_VALUE;
            for (int i : visit) {
                if(i>max){
                    max=i;
                }
            }
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < visit.length; i++) {
                if(max==visit[i]){
                    arr.add(i);
                }
            }
            Collections.sort(arr,Collections.reverseOrder());
            System.out.println("#"+test_case+" "+arr.get(0));
        }

    }

    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = 1;

        while (!q.isEmpty()) {
            int n = 0;
            Integer[] temp = new Integer[20];
            int z = q.poll();


            for (int i = 0; i < arr.get(z).size(); i++) {
                if (visit[arr.get(z).get(i)]==0) {
                    visit[arr.get(z).get(i)] = visit[z]+1;
                    q.offer(arr.get(z).get(i));
                    
                }
            }

        }
    }
}
