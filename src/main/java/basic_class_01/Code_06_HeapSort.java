package basic_class_01;

import util.ArrayUtil;

import java.util.Arrays;

import static util.ArrayUtil.*;
import static util.ArrayUtil.isEqual;

/**
 * 堆排序
 *
 * @Author: FangJu
 * @Date: 2019/8/7
 */
public class Code_06_HeapSort {
    public static void main(String[] args) {
        int maxTime = 50 * 10000;//测试次数
        int maxSize = 100;//数组最大大小
        int maxValue = 100;//数组子项最大值
        boolean isSucceed = true;//是否测试成功
        for (int i = 0; i < maxTime; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);//随机生成的数组
            int[] array2 = arrayCopy(array1);//存放正确结果的数组
            int[] array3 = arrayCopy(array1);//待排序的数组
            heapSort(array3);
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
     * 堆排序
     *
     * @param arr 待排数组
     */
    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //将数组转换成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //默认堆大小
        int heapSize = arr.length;
        //交换根结点和最后一个叶子结点的位置
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //重新调整位置，使数组符合大根堆
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 大根堆转换
     * 将数组构想成二叉树，即对应关系为
     * 父结点i的左孩子=2 * i + 1
     * 父结点i的右孩子=2 * i + 2
     * 左右孩子i的父结点=(i - 1) / 2
     *
     * @param arr   待转数组
     * @param index 待转索引位
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {//当前位置的值比父节点的值大
            swap(arr, index, (index - 1) / 2);//交换它们位置
            index = (index - 1) / 2;//当前位置指向父节点
        }
    }

    /**
     * 调整堆
     *
     * @param arr      数组
     * @param index    当前位置
     * @param heapSize 堆大小
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//当前位置节点的左孩子
        while (left < heapSize) {
            int largest = (left + 1 < heapSize) && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;//右孩子存在且其值大于左孩子，那么返回右孩子索引位，否则返回左孩子索引位
            largest = arr[largest] > arr[index] ? largest : index;//左右孩子中最大值比当前结点大，返回largest
            if (largest == index) {//否则结束比较
                break;
            }
            swap(arr, largest, index);//交换位置
            index = largest;
            left = index * 2 + 1;
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
