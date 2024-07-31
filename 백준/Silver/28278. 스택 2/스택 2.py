import sys

N = int(sys.stdin.readline())

L = []
for i in range(N):
    S = list(map(int, sys.stdin.readline().split()))

    X = S[0]
    if X == 1:
        L.append(S[1])
    elif X == 2:
        if len(L) >= 1:
            print(L.pop())
        else:
            print(-1)
    elif X == 3:
        print(len(L))
    elif X == 4:
        if len(L) == 0:
            print(1)
        else:
            print(0)
    elif X == 5:
        if len(L) > 0:
            print(L[len(L) - 1])
        else:
            print(-1)