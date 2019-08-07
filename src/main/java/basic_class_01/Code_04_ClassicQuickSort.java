package basic_class_01;

import util.ArrayUtil;

import java.util.Arrays;

import static util.ArrayUtil.*;
import static util.ArrayUtil.isEqual;

/**
 * 经典快速排序
 *
 * @Author: FangJu
 * @Date: 2019/8/7
 */
public class Code_04_ClassicQuickSort {
    public static void main(String[] args) {
        int maxTime = 50 * 10000;//测试次数
        int maxSize = 100;//数组最大大小
        int maxValue = 100;//数组子项最大值
        boolean isSucceed = true;//是否测试成功
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);//随机生成的数组
            int[] array2 = arrayCopy(array1);//存放正确结果的数组
            int[] array3 = arrayCopy(array1);//待排序的数组
            classicQuickSort(array3, 0, array3.length - 1);
            rightMethod(array2);
            if (!isEqual(array3, array2)) {
                isSucceed = false;
                ArrayUtil.printCompareResult(array1, array3, array2);
                break;
            }
        }
        System.out.println(isSucceed ? "Nice!" : "Error!");
    }

    /**
     * 经典快排
     * @param arr 待排的数组
     * @param l   数组左边界
     * @param r   数组右边界
     */
    private static void classicQuickSort(int[] arr, int l, int r) {
        if (l < r) {
            int partition = partition(arr, l, r);//把l->r组成的数组进行划分[<=x , x , >x]，x为数组最后一个数
            classicQuickSort(arr, l, partition - 1);//划分 <=x 部分
            classicQuickSort(arr, partition + 1, r);//划分 >x 部分
        }
    }
    /**
     * 划分
     *
     * @param arr 待划分数组
     * @param l   数组左边界
     * @param r   数组右边界
     * @return 待排数组最后一个数排完的位置
     */
    private static int partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] <= arr[r]) {
                swap(arr, l++, ++less);
            } else {
                swap(arr, l, --more);
            }
        }
        swap(arr, more, r);
        return more;
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
