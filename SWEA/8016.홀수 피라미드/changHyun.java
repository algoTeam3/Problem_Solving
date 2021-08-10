import java.util.Scanner;

public class SWEA_D3_8016_홀수피라미드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long floor = 0;
		
		for (int t = 1; t <= T; t++) {
			floor = sc.nextInt();
			if( floor == 1) {
				System.out.println("#" + t + " " + floor + " " + floor);
				continue;
			}
			long R = floor * floor * 2 -1;
			long L = R - (floor * 2 - 2) * 2;
			
			System.out.println("#" + t + " " + L + " " + R);
		}
	}
}

			//재귀함수 사용시 런타임 에러
			/*long N = 3, K = 7;
			long L = 1;
			long R = 1;
			if(floor == 1) {
				System.out.println("#" + t + " " + floor + " " + floor);
				continue;
			}else if(floor == 2) {
				System.out.println("#" + t + " " + N + " " + K);
				continue;
			}else {
				L += permutation(2, floor);
				R += permutation(6, floor);
				System.out.println("#" + t + " " + L + " " + R);
			}
		}
	}


	private static long permutation(long sum, long cnt) {
		if(cnt < 2) {
			return 0;
		}
		return sum + permutation(sum + 4, cnt - 1);
	}*/
