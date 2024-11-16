def solution(my_string, alp):
    answer = my_string
    if alp in my_string:
        answer = my_string.replace(alp, alp.upper())
    return answer