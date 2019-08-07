package basic_class_01;

import util.ArrayUtil;

import static util.ArrayUtil.*;

/**
 * 冒泡排序（很少用）
 *
 * @Author: fangju
 * @Date: 2019/8/4
 */
public class Code_00_BubbleSort {

    public static void main(String[] args) {
        int maxTime = 50 * 10000;//测试次数
        int maxSize = 100;//数组最大大小
        int maxValue = 100;//数组子项最大值
        boolean isSucceed = true;//是否测试成功
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);//随机生成的数组
            int[] array2 = arrayCopy(array1);//存放正确结果的数组
            int[] array3 = arrayCopy(array1);//待排序的数组
            bubbleSort(array3);
            rightMethod(array2);
            if (!isEqual(array3, array2)) {
                isSucceed = false;
                ArrayUtil.printCompareResult(array1,array3,array2);
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
            for (int i = 2; i < end; i++) {
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
