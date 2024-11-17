def solution(nums):
    answer = 0
    x = len(nums) / 2
    num = set(nums)
    
    if len(num) <= x:
        answer = len(num)
    else :
        answer = x
    return answer