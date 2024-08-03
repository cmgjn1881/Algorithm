import sys

N = int(sys.stdin.readline())
L = set(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
L2 = list(map(int, sys.stdin.readline().split()))

for i in L2:
    print(1) if i in L else print(0)