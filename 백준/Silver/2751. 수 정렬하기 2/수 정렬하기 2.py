import sys

N = int(input())
L = []
for _ in range(N):
    a = int(sys.stdin.readline())
    L.append(a)

L.sort()

for i in range(N):
    print(L[i])