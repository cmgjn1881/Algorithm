def solution(priorities, location):
    answer = 0
    maxp = max(priorities)
    maxindex = priorities.index(maxp)
    
    while True:
        if maxindex == location:
            answer += 1
            break
        priorities[maxindex] = 0
        answer += 1
        L1, L2 = priorities[:maxindex], priorities[maxindex:]
        maxp = max(priorities)
        if maxp in L2:
            maxindex += L2.index(maxp)
        else:
            maxindex = priorities.index(maxp)
            
    return answer