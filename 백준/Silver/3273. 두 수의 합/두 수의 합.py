import sys

n = int(sys.stdin.readline())
L = list(map(int, sys.stdin.readline().split()))
L2 = set(L)
X = int(sys.stdin.readline())

cnt = 0

for i in range(n):
    k = X - L[i]
    if k in L2:
        cnt += 1

print(cnt // 2)