package medium.unknown;

public class Med59 {

	public static void main(String[] args) {
		int n=7;
		int[][] res = Solution.generateMatrix(n);
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}

}
