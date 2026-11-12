class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        largest_count = 0

        if (len(nums_set) == 1):
            return 1

        for num in nums_set:
            
            if not (num - 1) in nums_set:

                # Start of a sequence
                count = 1
                curr = num

                while((curr + 1) in nums_set):
                    count += 1
                    curr += 1

                # End of the sequence
                if (largest_count < count):
                    largest_count = count

        return largest_count
