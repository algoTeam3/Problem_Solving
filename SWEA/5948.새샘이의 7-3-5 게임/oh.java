import java.util.*;

public class Expert5948 {
    static int r, n,z;
    static boolean isSelect[];
    static int input[];
    static Integer arr[];
    static int count;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =
                "2\n" +
                "1 2 3 4 5 6 7\n" +
                "5 24 99 76 1 77 6";

        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            count=0;
            z=0;
            n = 7;
            r = 3;
            input = new int[n];
            isSelect = new boolean[n];
            arr = new Integer[35];
            for (int i = 0; i < input.length; i++) {
                input[i] = sc.nextInt();
            }
            dfs(0, 0, 0);

            Set<Integer> hashSet = new HashSet<>(Arrays.asList(arr));
            Integer[] result = hashSet.toArray(new Integer[0]);
            Arrays.sort(result, (o1,o2)-> o2-o1);

            System.out.println("#"+test_case+" "+result[4]);

        }
    }

    static void dfs(int cnt, int start, int sum) {
        if (cnt == r) {
        count++;
            arr[z++]=sum;



            return;
        }
        for (int i = start; i < input.length; i++) {
            if (isSelect[i]) continue;
//            arr[cnt]=input[i];
            isSelect[i] = true;
            sum += input[i];
            dfs(cnt + 1, i+1, sum);
            isSelect[i] = false;
            sum -= input[i];

        }

    }

}
