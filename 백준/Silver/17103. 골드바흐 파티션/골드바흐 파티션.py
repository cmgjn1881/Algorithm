import sys

L = [1 for _ in range(1000001)]

for i in range(2, 1000001):
    if L[i]:
        for j in range(2 * i, 1000001, i):
            L[j] = 0

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())

    cnt = 0

    for i in range(2, (N // 2 + 1)):
        if L[i] and L[N - i]:
            cnt += 1

    print(cnt)