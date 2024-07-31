import sys
from collections import deque

N = int(sys.stdin.readline())

Q = deque([])

for _ in range(N):
    L = sys.stdin.readline().split()

    X = L[0]
    if X == "push":
        Q.append(L[1])
    elif X == "pop":
        if len(Q) == 0:
            print(-1)
        else:
            print(Q.popleft())
    elif X == "size":
        print(len(Q))
    elif X == "empty":
        if len(Q) == 0:
            print(1)
        else:
            print(0)
    elif X == "front":
        if len(Q) == 0:
            print(-1)
        else:
            print(Q[0])
    elif X == "back":
        if len(Q) == 0:
            print(-1)
        else:
            print(Q[-1])