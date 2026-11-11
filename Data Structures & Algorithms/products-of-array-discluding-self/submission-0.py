class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [1] * len(nums)

        left = 0
        leftProduct = 1

        right = len(nums) - 1
        rightProduct = 1 

        for i in range(len(nums)):

            if (left < i):
                leftProduct = leftProduct * nums[left]
                left += 1
            
            output[i] = leftProduct

        for i in range(len(nums) - 1, -1, -1):

            if (right > i):
                rightProduct = rightProduct * nums[right]
                right -= 1

            output[i] = output[i] * rightProduct
        
        return output