class Solution:
    def isPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s) - 1

        # aba
        # abba
        # ababa

        isPal = True

        while left < right:
            
            # find the left char
            while left < right and not s[left].isalnum():
                left += 1
            
            # find the right char
            while left < right and not s[right].isalnum():
                right -= 1

            # compare
            if s[left].lower() != s[right].lower():
                isPal = False
                break
            
            left += 1
            right -= 1
        
        return isPal