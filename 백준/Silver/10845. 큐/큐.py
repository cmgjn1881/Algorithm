import sys
from collections import deque

Q = deque()

def queue(x):
    if x[0] == "push":
        Q.append(x[1])
    elif x[0] == "pop":
        if len(Q) == 0:
            print(-1)
        else:
            print(Q.popleft())
    elif x[0] == "size":
        print(len(Q))
    elif x[0] == "empty":
        if len(Q) == 0:
            print(1)
        else:
            print(0)
    elif x[0] == "front":
        if len(Q) == 0:
            print(-1)
        else:
            print(Q[0])
    elif x[0] == "back":
        if len(Q) == 0:
            print(-1)
        else:
            print(Q[-1])


N = int(sys.stdin.readline())

for i in range(N):
    S = list(sys.stdin.readline().split())
    queue(S)

