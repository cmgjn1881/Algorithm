import sys

D = {}

N = int(sys.stdin.readline())

L = list(map(int, sys.stdin.readline().split()))

L.sort()

for i in range(1, N):
    L[i] = L[i] + L[i - 1]

print(sum(L))