package basic_class_01;

/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在
 * 数组的右边。
 * @Author: FangJu
 * @Date: 2019/8/6
 */
public class Code_08_NetherlandsFlag {
    public static void main(String[] args) {

    }

    /**
     * 划分
     * @param arr 待划分数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @param target 目标数
     * @return 与目标数相等的在划分后数组中的范围
     */
    private static int[] partition(int[] arr, int l, int r, int target) {
        int less = l - 1;//小于目标数在数组中的边界，默认不存在
        int more = r + 1;//大于目标数在数组中的边界，默认不存在
        int cur = l;//数组当前位置索引
        while (cur < more) {
            if (arr[cur] < target) {//当前数 < 目标数
                //把小于目标数的边界的下一个数与当前数交换//++less代表less+1之后，cur++代表cur+1之前
                swap(arr, ++less, cur++);
            } else if (arr[cur] > target) {//当前数 > 目标数
                //把大于目标数的边界的前一个数与当前数交换，
                // 交换完之后不确定当前数是否小于目标数，当前位置不变，进行下一轮
                swap(arr, --more, cur);
            } else {//当前数 = 目标数
                cur++;
            }
        }
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
