package ds.serach;

public class Singlenum {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 1, 7, 7};
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
    }
}
