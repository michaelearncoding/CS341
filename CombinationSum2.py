class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        res = []
        candidates.sort()
    
        def dfs(cur, pos, target):

            # base case
            if target == 0:
                res.append(cur.copy())
            if target <= 0:
                return
            
            prev = -1
            for i in range(pos, len(candidates)):
                if candidates[i] == prev:
                    continue
                cur.append(candidates[i])
                dfs(cur, i + 1, target - candidates[i]) # 核心的 i+1 是因为每个元素只能用一次
                cur.pop() # 去掉最后一个元素，回溯，继续循环
                prev = candidates[i]
        
        dfs([], 0, 0)# initialize
        return res