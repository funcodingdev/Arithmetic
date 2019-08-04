package util;

import java.util.Arrays;

/**
 * @Author: fangju
 * @Date: 2019/8/4
 */
public class ArithmeticUtil {
    /**
     * 2.实现一个绝对正确的方法
     *
     * @param arr
     */
    public static void rightResult(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 3.实现一个随机样本产生器
     * Math.random():返回double类型的[0,1)之间的数
     *
     * @param maxSize  数组的最大大小
     * @param maxValue 数组数值的最大值
     * @return 返回一个最大长度位maxSize，每一个位置在范围[-maxValue,maxValue]的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];//产生一个[0,maxSize]的数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组拷贝
     *
     * @param arr
     * @return
     */
    public static int[] arrayCopy(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    /**
     * 数组比较
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印排序结果
     * @param sortArray
     * @param rightArray
     */
    public static void printCompareResult(int[] newArray,int[] sortArray, int[] rightArray){
        System.out.println("生成结果="+Arrays.toString(newArray));
        System.out.println("排序结果="+Arrays.toString(sortArray));
        System.out.println("正确结果="+Arrays.toString(rightArray));
    }
}
