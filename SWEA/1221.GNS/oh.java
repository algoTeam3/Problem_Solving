import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n =st.nextToken();
            int len = Integer.parseInt(st.nextToken());
            StringBuilder sb0 = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            StringBuilder sb9 = new StringBuilder();
            st=new StringTokenizer(br.readLine());
            //"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
            for (int i = 0; i < len; i++) {
                String str = st.nextToken();
                switch (str){
                    case "ZRO":
                        sb0.append(str+" ");
                        break;
                    case "ONE":
                        sb1.append(str+" ");
                        break;
                    case "TWO":
                        sb2.append(str+" ");
                        break;
                    case "THR":
                        sb3.append(str+" ");
                        break;
                    case "FOR":
                        sb4.append(str+" ");
                        break;
                    case "FIV":
                        sb5.append(str+" ");
                        break;
                    case "SIX":
                        sb6.append(str+" ");
                        break;
                    case "SVN":
                        sb7.append(str+" ");
                        break;
                    case "EGT":
                        sb8.append(str+" ");
                        break;
                    case "NIN":
                        sb9.append(str+" ");
                        break;
                }
            }
            System.out.println(n);
            System.out.println(sb0);
            System.out.println(sb1);
            System.out.println(sb2);
            System.out.println(sb3);
            System.out.println(sb4);
            System.out.println(sb5);
            System.out.println(sb6);
            System.out.println(sb7);
            System.out.println(sb8);
            System.out.println(sb9);


        }
    }
}
