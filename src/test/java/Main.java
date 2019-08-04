import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: fangju
 * @Date: 2019/8/4
 */
public class Main {
    @Test
    public void test1(){
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[3];
        System.out.println(arr1);
        System.arraycopy(arr1,0,arr2,0,3);
        System.out.println(arr2);
    }
}
