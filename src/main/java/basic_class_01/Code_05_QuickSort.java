package basic_class_01;

import util.ArrayUtil;

import java.util.Arrays;

import static util.ArrayUtil.*;
import static util.ArrayUtil.isEqual;

/**
 * 改进后的快速排序
 *
 * @Author: FangJu
 * @Date: 2019/8/7
 */
public class Code_05_QuickSort {
    public static void main(String[] args) {
        int maxTime = 50 * 10000;//测试次数
        int maxSize = 100;//数组最大大小
        int maxValue = 100;//数组子项最大值
        boolean isSucceed = true;//是否测试成功
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);//随机生成的数组
            int[] array2 = arrayCopy(array1);//存放正确结果的数组
            int[] array3 = arrayCopy(array1);//待排序的数组
            quickSort(array3, 0, array3.length - 1);
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
     * 快速排序
     *
     * @param arr 待排的数组
     * @param l   数组左边界
     * @param r   数组右边界
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);//将数组中任意位置中的数与最后一个数交换
            int[] partition = partition(arr, l, r);//把l->r组成的数组进行划分[<x , x, >x]，x为数组最后一个数
            quickSort(arr, l, partition[0] - 1);//划分 <x 部分
            quickSort(arr, partition[1] + 1, r);//划分 >x 部分
        }
    }

    /**
     * 划分
     *
     * @param arr 待划分数组
     * @param l   数组左边界
     * @param r   数组右边界
     * @return 等于x部分在数组中的范围
     */
    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;//指向<x的最大索引位
        int more = r;//指向>x的最大索引位
        while (l < more) {//当前位置小于>x的最大索引位
            if (arr[l] < arr[r]) {//当前位置值<最后一个数
                swap(arr, l++, ++less);//当前值与<x的索引位下一个值交换，当前位置+1
            } else if (arr[l] > arr[r]) {//当前位置值>最后一个数
                swap(arr, l, --more);//当前值与>x的索引位前一个值交换
            } else {
                l++;
            }
        }
        //此时more指向的是>=最后一个数的边界
        swap(arr, more++, r);//将more位置的数和最后一个数交换，more+1代表more为>x数组的左边界
        return new int[]{less + 1, more - 1};
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
