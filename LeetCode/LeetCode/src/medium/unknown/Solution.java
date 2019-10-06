package medium.unknown;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

public class Solution {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int n = matrix.length;
		if(n==0)return list;
		int m = matrix[0].length;
		int s = n * m;
		int up = 0, down = n, left = 0, right = m;
		while (s > 0) {
			for (int col = left; col < right && s > 0; ++col, --s)
				list.add(matrix[up][col]);
			++up;
			for (int row = up; row < down && s > 0; ++row, --s)
				list.add(matrix[row][right - 1]);
			--right;
			for (int col = right - 1; col >= left && s > 0; --col, --s)
				list.add(matrix[down - 1][col]);
			--down;
			for (int row = down - 1; row >= up && s > 0; --row, --s)
				list.add(matrix[row][left]);
			++left;
		}
		return list;

	}

	public static int[][] generateMatrix(int n) {
		int[][] arr = new int[n][n];
		int val = 1;
		for (int i = 0, p = n; i < n / 2 + n % 2; ++i, p--) {
			for (int col = i; col < p; ++col)
				arr[i][col] = val++;
			for (int row = i + 1; row < p; ++row)
				arr[row][p - 1] = val++;
			for (int col = p - 2; col >= i; --col)
				arr[p - 1][col] = val++;
			for (int row = p - 2; row > i; --row)
				arr[row][i] = val++;
		}
		return arr;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tem = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			tem.add(nums[i]);
		}
		PermuteDFS(tem, 0, res);
		return res;
	}

	public static void PermuteDFS(List<Integer> tem, int start, List<List<Integer>> res) {
		if (start >= tem.size()) {
			res.add(new ArrayList<Integer>(tem));
		}
		for (int i = start; i < tem.size(); i++) {
			int t = tem.get(i);
			tem.set(i, tem.get(start));
			tem.set(start, t);
			PermuteDFS(tem, start + 1, res);
			t = tem.get(i);
			tem.set(i, tem.get(start));
			tem.set(start, t);
		}
	}
}
