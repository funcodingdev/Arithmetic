package basic_class_01;

import util.ArithmeticUtil;

import java.util.Arrays;

import static util.ArithmeticUtil.*;
import static util.ArithmeticUtil.isEqual;

/**
 * @Author: fangju
 * @Date: 2019/8/4
 */
public class Code_02_InsertionSort {

    public static void main(String[] args) {
        int maxTime = 50 * 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSucceed = true;
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);
            int[] array2 = arrayCopy(array1);
            int[] array3 = arrayCopy(array1);
            insertionSort(array1);
            rightResult(array2);
            if (!isEqual(array1, array2)) {
                isSucceed = false;
                ArithmeticUtil.printCompareResult(array3,array1,array2);
                break;
            }
        }
        System.out.println(isSucceed ? "Nice!" : "Error!");
    }

    /**
     * 插入排序,时间复杂度=o（N^2）
     *
     * @param arr 待排的数组
     */
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 交换数组中i和j的位置
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
