# https://www.youtube.com/watch?v=GBKI9VSKdGg
# Combination Sum - Backtracking - Leetcode 39 - Python

class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        res = []
        candidates.sort()
        self.dfs(candidates, target)
    
        def dfs(i, cur, total):

            # base case
            if total == target:
                res.append(cur)
                return
            if i >= len(candidates) or total > target:
                return
            
            cur.append(candidates[i])
            dfs(i, cur, total + candidates[i])
            cur.pop()
            dfs(i + 1, cur, total)
        
        dfs(0, [], 0)
        return res








