import java.util.Arrays;

public class SortBinary {
    public static int[] sortBinary(int[] nums){
        // 1 to left, 0 to right

        // corner case
        if (nums ==null || nums.length == 0){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left<= right){
            while(left<= right && nums[left] == 1){
                left ++;
            }
            while(left<= right && nums[right] == 0){
                right --;
            }
            if(left <= right) {
                nums = swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }
    private static int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
    public static void main(String[] args) {
        int[] array = { 0, 1, 1, 0, 1, 0 };
        System.out.println("Before sorting: " + Arrays.toString(array));
        SortBinary.sortBinary(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
