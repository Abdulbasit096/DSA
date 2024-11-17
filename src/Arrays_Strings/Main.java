package Arrays_Strings;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1,3},{8,10},{2,6},{15,18}})));
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(Arrays.deepToString(solution.rotateImage(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}})));








    }
}
