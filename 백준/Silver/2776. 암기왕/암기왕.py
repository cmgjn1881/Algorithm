import sys

T = int(sys.stdin.readline())

for i in range(T):
    N = int(sys.stdin.readline())
    S = set(map(int, sys.stdin.readline().split()))

    M = int(sys.stdin.readline())
    L = list(map(int, sys.stdin.readline().split()))

    for x in L:
        if x in S:
            print(1)
        else:
            print(0)