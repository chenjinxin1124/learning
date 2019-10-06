package interview.topN;

import java.util.Random;

public class TopNPartition {
	public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        topN(arr, 0, arr.length - 1,5);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
	public static void topN(int[] arr, int head, int tail, int k) {
		Random random = new Random();
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail; 
        int par=random.nextInt(j-i+1)+i;
        int pivot = arr[par];
        
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        int t=tail-j;
        if(t==k)return;
        if(t<k)topN(arr, head, j,k-t);
        else topN(arr, i, tail,k);
    }
	
}
