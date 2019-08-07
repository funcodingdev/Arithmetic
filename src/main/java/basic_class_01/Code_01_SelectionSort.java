package basic_class_01;

import util.ArrayUtil;

import static util.ArrayUtil.*;
import static util.ArrayUtil.isEqual;

/**
 * 选择排序（很少用）
 *
 * @Author: FangJu
 * @Date: 2019/8/4
 */
public class Code_01_SelectionSort {

    public static void main(String[] args) {
        int maxTime = 50 * 1000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSucceed = true;
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);
            int[] array2 = arrayCopy(array1);
            int[] array3 = arrayCopy(array1);
            selectionSort(array1);
            rightMethod(array2);
            if (!isEqual(array1, array2)) {
                isSucceed = false;
                ArrayUtil.printCompareResult(array3,array1,array2);
                break;
            }
        }
        System.out.println(isSucceed ? "Nice!" : "Error!");
    }

    /**
     * 选择排序，时间复杂度=O（N^2）=（N-1）*（N-2）*（N-3）*...*1
     *
     * @param arr 待排的数组
     */
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//最小数在数组中的索引，默认为i
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;//当前位置的数比最小值要小吗？返回当前位置为最小值位置：最小值仍然位当前位置
            }
            swap(arr, minIndex, i);//交换位置
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
