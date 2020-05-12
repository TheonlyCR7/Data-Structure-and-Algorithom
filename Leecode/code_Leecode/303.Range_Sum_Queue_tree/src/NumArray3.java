//307. 区域和检索 - 数组可修改
//给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
//
// update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

public class NumArray3 {

    private int[] data;
    private int[] sum;

    public NumArray3(int[] nums) {

        data = new int[nums.length];
        for(int i = 0; i < nums.length; i ++)
            data[i] = nums[i];

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i ++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public void update(int index, int val) {
        data[index] = val;
        for(int i = index + 1; i < sum.length; i ++)
            sum[i] = sum[i - 1] + data[i - 1];
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

//update  为 O(n) 的复杂度，  耗用时间较长
// 执行用时 :124 ms, 在所有 Java 提交中击败了27.30% 的用户
// 内存消耗 :45.6 MB, 在所有 Java 提交中击败了85.37%的用户