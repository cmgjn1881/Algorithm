def solution(s):
    answer = ''
    dict = {}

    for i in range(len(s)):
        if s[i] in dict:
            dict[s[i]] += 1
        else:
            dict[s[i]] = 1

    for key, value in dict.items():
        if value == 1:
            answer += key
    
    return ''. join(sorted(answer))