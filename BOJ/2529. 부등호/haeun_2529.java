import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {
	
	public static int k;
	public static int[] num;
	public static String[] cal;
	public static boolean[] checked;
	public static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());	// 부등호 문자의 수
		cal = new String[k];					// 부등호
		num = new int[k+1];						// 수
		checked = new boolean[10];
		list = new ArrayList<>();
		
		// 부등호 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			cal[i] = st.nextToken();
		}
		
		perm(0);
		// 오름차순으로 정렬
		Collections.sort(list);
		// 출력
		System.out.print(list.get(list.size()-1) + "\n" + list.get(0));
	}
	
	// 순열
	public static void perm(int n) {
		// 기저조건
		if (n == k+1) {
			String str = "";
			for (int i : num) str += i;
			list.add(str);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (checked[i]) continue;
			// 부등호 체크
			if (check(n, i)) {
				checked[i] = true;
				num[n] = i;
				perm(n+1);
				checked[i] = false;
			}
		}
	}
	
	// 부등호 체크
	public static boolean check(int n, int i) {
		if (n == 0) return true;
		if (cal[n-1].equals(">")) return num[n-1] > i ? true : false;
		else return num[n-1] < i ? true : false;
	}
}
