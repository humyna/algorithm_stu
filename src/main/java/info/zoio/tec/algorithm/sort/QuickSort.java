package info.zoio.tec.algorithm.sort;

import java.util.Random;

public class QuickSort {
	public static final Random RND = new Random();

	public static void main(String[] args) {

//		Random random = new Random();
		int[] array = new int[8];//疑问：为什么数组大小大于8就报错java.lang.StackOverflowError

		for (int i = 0; i < array.length; i++) {
			array[i] = RND.nextInt(25);
		}

		System.out.println("Before Quick Sort:");
		for (int i : array) {
			System.out.print(i + " ");
		}

		long startTime = System.currentTimeMillis();

		quickSort(array, 0, array.length-1);//快速排序

		long endTime = System.currentTimeMillis();

		System.out.println("Times:" + (endTime - startTime));

		System.out.println("After Quick Sort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] array, int begin, int end){
		if(end > begin){
			int index = partition(array, 0, array.length-1);

			quickSort(array,begin,index-1);
			quickSort(array,index+1,end);
		}
	}

	private static int partition(int[] array, int begin, int end){
		int index = begin + RND.nextInt(end - begin + 1);
		int pivot = array[index];
		swap(array,index,end);
		for (int i = index = begin; i < end; ++i) {
			if(array[i] <= pivot){
				swap(array,index++,i);
			}
		}

		swap(array,index,end);
		return index;
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

	}

}
