import sys

N = int(sys.stdin.readline())

L = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())

L2 = list(map(int, sys.stdin.readline().split()))

for i in range(len(L2)):
    if L2[i] in L:
        print("1", end=" ")
    else:
        print("0", end=" ")