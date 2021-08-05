import java.util.Scanner;

public class SWEA_D3_1206_View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int W = sc.nextInt();
			int[] build = new int[W];
			int ans = 0;
			int interrupt = 0;
			
			for(int i = 0; i < W; i++) {
				build[i] = sc.nextInt();
			}
			
			for(int i = 2; i < W - 2; i++) {
				
				interrupt = Math.max(build[i-2], Math.max(build[i-1], Math.max(build[i+1], build[i+2])));
				if(build[i] - interrupt > 0) {
					ans += build[i] - interrupt;
				}
						
				
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
