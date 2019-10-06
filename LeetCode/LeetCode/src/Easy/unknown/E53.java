package easy.unknown;
/*
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class E53 {

	public static void main(String[] args) {
		int arr[]= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(Solution.maxSubArray(arr));//O(n)
		System.out.println(Solution.maxSubArray2(arr));//O(nlgn)
	}
}
