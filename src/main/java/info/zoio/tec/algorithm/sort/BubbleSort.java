package info.zoio.tec.algorithm.sort;

import java.util.Random;


/**
 * 冒泡排序算法的运作如下：
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 最差时间复杂度 O(n^2)
 * 最优时间复杂度 O(n)
 * 平均时间复杂度 O(n^2)
 * 最差空间复杂度 总共O(n)，需要辅助空间O(1)
 *
 * 冒泡排序是与插入排序拥有相等的执行时间，但是两种法在需要的交换次数却很大地不同。
 * 在最坏的情况，冒泡排序需要O(n^2)次交换，而插入排序只要最多O(n)交换。
 * @author Zoio
 *
 */


public class BubbleSort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] sort = new int[10];//问题：设定数组中元素为小于50的整数；当数组大小大于1459时就无法打印各个元素了，为什么？

		for (int i = 0; i < sort.length; i++) {
			sort[i] = random.nextInt(25);
		}

		System.out.println("Before Bubble Sort:");
		for (int i : sort) {
			System.out.print(i + " ");
		}

		long startTime = System.currentTimeMillis();
		bubbleSort(sort);
//		bubbleSort1(sort,sort.length);//使用标志位的冒泡排序
		long endTime = System.currentTimeMillis();

		System.out.println("Times:" + (endTime - startTime));

		System.out.println("After Bubble Sort:");
		for (int i : sort) {
			System.out.print(i + " ");
		}

	}

	/**
	 * 带标志位的冒泡排序
	 *
	 * @param sort
	 * @param length
	 */
	private static void bubbleSort1(int[] sort,int length) {
		//假定两两交换发生在数组的最后的两个位置
		int exchange = length - 1;
		int count = 0;

		while (exchange != 0){
			int bound = exchange;//记录下发生数据交换的位置

			exchange = 0;//假定本趟比较没有数据交换

			for (int i = 0; i < bound; i++) {
				if(sort[i] > sort[i+1]){
					int tmp = sort[i];
					sort[i] = sort[i+1];
					sort[i+1] = tmp;

					exchange = i + 1;
					count ++;
				}
			}

		}
		System.out.println();
		System.out.println("swap counts:" + count);
	}

	/**
	 * 冒泡排序
	 *
	 * @param sort
	 */
	private static void bubbleSort(int[] sort){
		int count = 0;

		for (int i = 1; i < sort.length; i++) {
			for (int j = 0; j < sort.length - i; j++) {
				if (sort[j] > sort[j+1]){
//					swap(sort[j],sort[j+1]);//error注意：小心此处的臭虫，无法交换数组的元素值
					swap(j,sort);//right

					count++;
				}
			}
		}
		System.out.println();
		System.out.println("swap counts:" + count);
	}

	/**
	 * 交换数组中两个元素的值
	 *
	 * @param j
	 * @param sort
	 */
	private static void swap(int i,int[] sort) {
		int tmp = sort[i];
		sort[i] = sort[i+1];
		sort[i+1] = tmp;
	}

	private static void swap(int i, int j) {//error!!!
		int tmp = j;
		j = i;
		i = tmp;
	}
}




