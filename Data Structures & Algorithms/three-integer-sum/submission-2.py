class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sorted_nums = sorted(nums)
        result = []

        for i in range(len(sorted_nums)):
            if i>0 and sorted_nums[i] == sorted_nums[i-1]:
                continue
            
            target = -sorted_nums[i]
            start = i+1
            end = len(sorted_nums)-1
            
            while start<end:
                current_sum = sorted_nums[start] + sorted_nums[end]
                
                if current_sum == target:
                    result.append([
                        sorted_nums[i], 
                        sorted_nums[start], 
                        sorted_nums[end]
                        ])
                    
                    start += 1
                    end -= 1

                    while start < end and sorted_nums[start] == sorted_nums[start-1]:
                        start += 1
                    while start < end and sorted_nums[end] == sorted_nums[end+1]:
                        end -= 1
                elif current_sum < target:
                    start += 1
                else:
                    end -= 1

        return result