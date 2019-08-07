package basic_class_01;

import java.util.Arrays;

/**
 * 逆序对问题 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序对
 * @Author: FangJu
 * @Date: 2019/8/5
 */
public class Code_13_InverseSequencePair {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 1, 4, 8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr 待排的数组
     */
    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    /**
     * 排序过程
     * @param arr 待排子数组
     * @param l 子数组开始位置
     * @param r 子数组结束位置
     */
    private static void sortProcess(int[] arr, int l, int r) {
        if (l == r) {//待排数组只有一个数时
            return;
        }
        int mid = l + ((r - l) >> 1);//数组索引中间值//int mid = (l + r) / 2的形式不安全
        sortProcess(arr, l, mid);//排mid左边的值
        sortProcess(arr, mid + 1, r);//排mid右边的值
        merge(arr, l, mid, r);//左右两边都排好之后进行左右两边排序
    }

    /**
     * 合并
     * @param arr 原数组
     * @param l 原数组左边部分起始值
     * @param mid 原数组中间索引号
     * @param r 原数组右边部分结束值
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];//辅助数组
        int i = 0;//辅助数组的下标
        int p1 = l;//左边数组的索引
        int p2 = mid + 1;//右边数组的索引
        while (p1 <= mid && p2 <= r) {//mid左边部分和右边部分均没有越界
            if(arr[p1] > arr[p2]){
                System.out.println(arr[p1]+":"+arr[p2]);
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //右边先排完,左边直接覆盖原数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        //左边先排完，右边直接覆盖原数组
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //数组拷贝
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
