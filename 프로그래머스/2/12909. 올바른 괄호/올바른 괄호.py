def solution(s):
    answer = True
    if s[0] == ')':
        return False
        
    L = []
    for i in s:
        if i == '(':
            L.append(i)
        else:
            if L:
                L.pop(-1)
            else:
                return False
    if L:
        answer = False
    return answer