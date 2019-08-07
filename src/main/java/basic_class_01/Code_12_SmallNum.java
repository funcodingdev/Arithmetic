package basic_class_01;

import java.util.Arrays;

/**
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
 * 例子：
 * [1,3,4,2,5] 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 * @Author: FangJu
 * @Date: 2019/8/5
 */
public class Code_12_SmallNum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(mergeSort(arr));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr 待排的数组
     * @return 小和
     */
    private static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return sortProcess(arr, 0, arr.length - 1);
    }

    /**
     * 排序过程
     * @param arr 待排子数组
     * @param l 子数组开始位置
     * @param r 子数组结束位置
     * @return 子项小和
     */
    private static int sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) / 2);
        return sortProcess(arr, l, mid)
                + sortProcess(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    /**
     * 合并
     * @param arr 原数组
     * @param l 原数组左边部分起始值
     * @param mid 原数组中间索引号
     * @param r 原数组右边部分结束值
     * @return 子项小和
     */
    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];//辅助数组
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int result = 0;
        while (p1 <= mid && p2 <= r) {
            result += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return result;
    }
}
