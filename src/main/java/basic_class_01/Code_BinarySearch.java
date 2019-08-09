package basic_class_01;

/**
 * @Author: FangJu
 * @Date: 2019/8/8
 */
public class Code_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr,  9));
    }

    /**
     * 二分法查找
     *
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr, int l, int r, int target) {
        if (arr == null || arr.length < 1 || l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (arr[mid] > target) {
            return binarySearch(arr, l, mid - 1, target);
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, r, target);
        } else if (arr[mid] == target) {
            return mid;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        if(arr == null || arr.length < 1){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(arr[mid] > target){
                high = mid - 1;
            }else if(arr[mid] < target){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
