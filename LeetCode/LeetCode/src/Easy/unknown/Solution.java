package easy.unknown;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static int maxSubArray(int[] nums) {
		int res = Integer.MIN_VALUE, curSum = 0;
		for (int num : nums) {
			curSum = Math.max(curSum + num, num);
			res = Math.max(res, curSum);
		}
		return res;
	}

	public static int maxSubArray2(int[] nums) {
		if (nums.length == 0)
			return 0;
		return helper(nums, 0, nums.length - 1);
	}

	public static int helper(int[] nums, int left, int right) {
		if (left >= right)
			return nums[left];
		int mid = left + (right - left) / 2;
		int lmax = helper(nums, left, mid - 1);
		int rmax = helper(nums, mid + 1, right);
		int mmax = nums[mid], t = mmax;
		for (int i = mid - 1; i >= left; --i) {
			t += nums[i];
			mmax = Math.max(mmax, t);
		}
		t = mmax;
		for (int i = mid + 1; i <= right; ++i) {
			t += nums[i];
			mmax = Math.max(mmax, t);
		}
		return Math.max(mmax, Math.max(lmax, rmax));
	}

	public static int numJewelsInStones(String J, String S) {
		int len = S.length();
		int count = 0;
		for (int i = 0; i < len; ++i) {
			if (J.indexOf(S.charAt(i)) >= 0) {
				++count;
			}
		}
		return count;
	}

	public static int climbStairs(int n) {
		double sqrt5 = 2.23606797749979;
		return (int) (sqrt5 / 5 * (Math.pow((1 + sqrt5) / 2, n * 1.0) - Math.pow((1 - sqrt5) / 2, n * 1.0)));
	}
}
