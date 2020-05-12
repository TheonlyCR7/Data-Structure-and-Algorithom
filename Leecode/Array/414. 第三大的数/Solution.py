class Solution:
    def thirdMax(self, nums):
        nums = sorted(nums, reverse=True)
        print(nums)
        j = 0
        for i in range(len(nums)):
            if i+2 > len(nums) :
                if j < 2:
                    return nums[0]
                else:
                    return nums[i]
            if nums[i] != nums[i + 1] and j < 3:
                j += 1
            elif nums[i + 1] == None:
                return nums[i]
            if j == 3:
                return nums[i]
            print(str(j) + '~~~' + str(i))


num = [4, 3, 2, 2, 4, 3]
s1 = Solution()
s = s1.thirdMax(num)
print(s)