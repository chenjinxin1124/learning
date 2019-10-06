package interview.topN;

import java.util.Random;

public class Main {
	public static void main(String[] args) {

		TopN topN = new TopN();

		int[] arr1 = new int[] { 56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34 };
		System.out.println("原数组：");
		print(arr1);
		System.out.println("调整后数组：");
		TopNPartition.topN(arr1,0,arr1.length-1,5);
		print(arr1,7,12);
		topN.findTopN(5, arr1);
		print(arr1,0,5);
		
		
		int[] arr2 = new int[100];
		for (int i=0; i<100; ++i) {
			arr2[i]=i;
		}
		System.out.println("原数组：");
		print(arr2);
		System.out.println("调整后数组：");
		TopNPartition.topN(arr2,0,arr2.length-1,10);
		print(arr2,90,100);
		topN.findTopN(10, arr2);
		print(arr2,0,10);//???
		
		Random random = new Random();
		int[] arr3 = new int[100];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = random.nextInt(1000);
		}

		System.out.println("原数组：");
		print(arr3);
		System.out.println("调整后数组：");
		TopNPartition.topN(arr3,0,arr3.length-1,50);
		print(arr3,50,100);
		topN.findTopN(50, arr3);
		print(arr3,0,50);
	}

	// 打印数组
    public static void print(int[] data,int s,int e) {
        for(int i = s; i < e; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
