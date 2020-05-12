import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {

        nums = Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i <= nums.length; i ++){
            if (i+2 > nums.length)
                if (j < 2)
                    return nums[0];
                else:
                    return nums[i];
            if (nums[i] != nums[i + 1] && j < 3)
                j ++;
            else if (nums[i+1] == null)
                return nums[i];
            if (j == 3)
                return nums[i]
        }
    }
}
