package basic_class_01;

import util.ArithmeticUtil;

import java.util.Arrays;

import static util.ArithmeticUtil.*;

/**
 * 冒泡排序（很少用）
 *
 * @Author: fangju
 * @Date: 2019/8/4
 */
public class Code_00_BubbleSort {

    public static void main(String[] args) {
        int maxTime = 50 * 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSucceed = true;
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);
            int[] array2 = arrayCopy(array1);
            int[] array3 = arrayCopy(array1);
            bubbleSort(array1);
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
     * 去除低阶项，保留高阶项，去除高阶项的系数
     * 冒泡排序，时间复杂度=o（N^2）=N*(N-1)*...*1=aN^2+bN+1
     *
     * @param arr 待排的数组
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
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
