package basic_class_01;

/**
 * 桶排序，计数排序
 * <p>
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 *
 * @Author: FangJu
 * @Date: 2019/8/9
 */
public class Code_11_MaxGap {
    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 1, 19};
        int m = maxGap(arr);
        System.out.println(m);
    }

    /**
     * 求最大差值
     *
     * @param arr 数组
     * @return 最大差值
     */
    private static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int length = arr.length;//数组的长度
        int min = Integer.MAX_VALUE;//数组中的最小值
        int max = Integer.MIN_VALUE;//数组中的最大值
        for (int cur : arr) {//找出数组中的最大值和最小值
            min = Math.min(cur, min);
            max = Math.max(cur, max);
        }
        if (min == max) {//所有数相同
            return 0;
        }
        boolean[] hasNums = new boolean[length + 1];//当前桶是否有值
        int[] mins = new int[length + 1];//每个桶中的最小值
        int[] maxs = new int[length + 1];//每个桶中的最大值
        int bid = 0;//桶下标
        for (int cur : arr) {
            bid = bucket(cur, length, min, max);//当前值所属桶的下标
            //第一次桶中最大最小值为入桶的第一个数，以后每次都比较更新
            mins[bid] = hasNums[bid] ? Math.min(mins[bid], cur) : cur;
            maxs[bid] = hasNums[bid] ? Math.max(maxs[bid], cur) : cur;
            hasNums[bid] = true;
        }
        int res = 0;//最大差值
        int lastMax = maxs[0];//桶中数据的最大值
        for (int i = 1; i < length + 1; i++) {
            if (hasNums[i]) {//当前桶是否有数入过
                res = Math.max(mins[i] - lastMax, res);//最大差值 = 当前桶中最小值 - 前一个桶中最大值
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 当前值所属桶的下标
     * (num - min)/ (max - min) 代表当前值在桶长度中的比例
     *
     * @param num    当前数
     * @param length 数组的长度
     * @param min    桶中最小值
     * @param max    桶中最大值
     * @return 桶的下标
     */
    private static int bucket(long num, int length, int min, int max) {
        return (int) ((num - min) * length / (max - min));
    }
}
