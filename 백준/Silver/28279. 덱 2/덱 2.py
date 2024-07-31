import sys
from collections import deque

N = int(sys.stdin.readline())
Q = deque()

for i in range(N):
    S = list(map(int, sys.stdin.readline().split()))

    X = S[0]
    if X == 1:
        Q.appendleft(S[1])
    elif X == 2:
        Q.append(S[1])
    elif X == 3:
        if len(Q) == 0:
            print(-1)
        else:
            print(Q.popleft())
    elif X == 4:
        if len(Q) == 0:
            print(-1)
        else:
            print(Q.pop())
    elif X == 5:
        print(len(Q))
    elif X == 6:
        if len(Q) == 0:
            print(1)
        else:
            print(0)
    elif X == 7:
        if len(Q) == 0:
            print(-1)
        else:
            print(Q[0])
    elif X == 8:
        if len(Q) == 0:
            print(-1)
        else:
            print(Q[-1])
