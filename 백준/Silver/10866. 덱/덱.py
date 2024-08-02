import sys
from collections import deque

D = deque()

def controlDedue(x):
    if x[0] == "push_front":
        D.appendleft(x[1])
    elif x[0] == "push_back":
        D.append(x[1])
    elif x[0] == "pop_front":
        if len(D) == 0:
            print(-1)
        else:
            print(D.popleft())
    elif x[0] == "pop_back":
        if len(D) == 0:
            print(-1)
        else:
            print(D.pop())
    elif x[0] == "size":
        print(len(D))
    elif x[0] == "empty":
        if len(D) == 0:
            print(1)
        else:
            print(0)
    elif x[0] == "front":
        if len(D) == 0:
            print(-1)
        else:
            print(D[0])
    elif x[0] == "back":
        if len(D) == 0:
            print(-1)
        else:
            print(D[-1])


N = int(sys.stdin.readline())

for _ in range(N):
    S = list(sys.stdin.readline().split())
    controlDedue(S)
