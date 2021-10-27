import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_10819 {
    static int n,max;
    static int[] arr,input;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        check=new boolean[n];
        input=new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        max=Integer.MIN_VALUE;
        Dfs(0);
        System.out.println(max);
    }

    private static void Dfs(int cnt) {
        if(cnt== n){
            cal();
            return;
        }

        for (int i = 0; i < check.length; i++) {
            if(check[i])continue;
            check[i]=true;
            input[cnt]=arr[i];
            Dfs(cnt+1);
            check[i]=false;
        }
    }
    private static void cal(){
        int sum=0;
        for (int i = 0; i < input.length-1; i++) {
            sum+=Math.abs(input[i]-input[i+1]);
        }
        max=Math.max(max,sum);

    }

}
