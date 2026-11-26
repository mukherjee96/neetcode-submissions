class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left, right = 0, len(heights) - 1
        maxWater = 0

        while(left < right):
            h1, h2 = heights[left], heights[right]
            water = (right - left) * min(h1, h2)

            if (maxWater < water):
                maxWater = water

            if (h1 == h2):
                left += 1
                right -= 1
            elif (h1 < h2):
                left += 1
            else:
                right -= 1
        
        return maxWater