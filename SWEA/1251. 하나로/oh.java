import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Expert1251 {
    static int v;
    static double E;
    static ArrayList<ArrayList<land>>arr;
    static boolean visit[];
    static PriorityQueue<land> pq;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\ttest\\algorithm\\algo\\src\\input\\input1251.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        //테스트케이스만큼 돌기
        for (int i = 1; i <= T; i++) {
            v =Integer.parseInt(br.readLine());
            //좌표 담기
            xy[] xies = new xy[v + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= v; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                xies[j]=new xy(x,y);
            }
            //세율 입력받기
            E =Double.parseDouble(br.readLine());
            //인접리스트 생성
            arr = new ArrayList<>();
            for (int j = 0; j < v+1; j++) {
                arr.add(new ArrayList<>());
            }
            //배열에 담기
            for (int j = 1; j < v+1; j++) {
                for (int k = j+1; k <v+1 ; k++) {
                    double value = (Math.pow(xies[j].x-xies[k].x,2)+Math.pow(xies[j].y-xies[k].y,2))*E;
                    arr.get(j).add(new land(k,value));
                    arr.get(k).add(new land(j,value));
                }
            }
            System.out.println("#" + i + " " + Math.round(Prim()));
        }

    }

    private static double Prim() {
        int cnt=0;
        double ret=0;
        visit= new boolean[v+1];
        pq=new PriorityQueue<>();
        pq.add(new land(1, 0));

        while (!pq.isEmpty()){
            land n = pq.poll();

            if(visit[n.to])continue;
            visit[n.to]=true;
            ret+=n.value;

            if(++cnt==v){
                return ret;
            }
            for (int i = 0; i < arr.get(n.to).size(); i++) {
                land next = arr.get(n.to).get(i);
                if(visit[next.to])continue;
                pq.add(next);
            }
        }

        return ret;
    }
}
class xy{
    int x;
    int y;
    xy(int x,int y){
        this.x=x;
        this.y=y;
    }

}
class land implements Comparable<land> {
    int to;
    double value;

    land(int to,double value){
        this.to=to;
        this.value=value;
    }


    @Override
    public int compareTo(land o) {//this.value-o.value하면 값 잘못나오는 case 
        return this.value>o.value?1:-1;
    }
