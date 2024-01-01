class Solution:
    def subsetWithDup(self, nums: list[int]) -> list[list[int]]:
        res = []
        nums.sort()
        
        def backtrack(i, subset):
            if i == len(nums):
                res.append(subset.copy())
                return
            
            # All subsets that include nums[i]
            subset.append(nums[i])
            backtrack(i + 1, subset)
            subset.pop()

            # All subsets that do not include nums[i]
            while i + 1 < len(nums) and nums[i] == nums[i + 1]: # skip duplicates (all of them )
                i += 1
            backtrack(i + 1, subset)
        
        backtrack(0, [])
        return res