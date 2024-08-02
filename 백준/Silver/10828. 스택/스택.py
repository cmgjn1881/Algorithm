import sys

L = []

def stack(x):
    if x[0] == "push":
        L.append(x[1])
    elif x[0] == "pop":
        if len(L) == 0:
            print(-1)
        else:
            print(L.pop())
    elif x[0] == "size":
        print(len(L))
    elif x[0] == "empty":
        if len(L) == 0:
            print(1)
        else:
            print(0)
    elif x[0] == "top":
        if len(L) == 0:
            print(-1)
        else:
            print(L[-1])

N = int(sys.stdin.readline())

for i in range(N):
    Cmd = list(sys.stdin.readline().split())
    stack(Cmd)