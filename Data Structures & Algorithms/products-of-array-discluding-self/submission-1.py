class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [1] * len(nums)

        leftProduct = 1
        rightProduct = 1 

        for i in range(len(nums)):

            output[i] = leftProduct
            leftProduct *= nums[i]

        for i in range(len(nums) - 1, -1, -1):

            output[i] = output[i] * rightProduct
            rightProduct *= nums[i]
        
        return output