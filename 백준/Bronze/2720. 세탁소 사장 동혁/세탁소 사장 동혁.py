T = int(input())

L = [[0]*4 for _ in range(T)]  # 각 테스트 케이스마다 4개의 값을 저장할 리스트

for i in range(T):
    C = int(input())
    remain = C

    while remain > 0:
        if remain >= 25:
            quotient, remain = divmod(remain, 25)
            L[i][0] = quotient
        elif remain >= 10:
            quotient, remain = divmod(remain, 10)
            L[i][1] = quotient
        elif remain >= 5:
            quotient, remain = divmod(remain, 5)
            L[i][2] = quotient
        else:
            L[i][3] = remain
            remain = 0  # 남은 값을 처리하고 종료

for i in range(T):
    for j in range(4):
        print(L[i][j], end=" ")
    print()
