import sys

N, M = map(int, sys.stdin.readline().split())

L = []
cnt = 0

for _ in range(N):
    A = str(sys.stdin.readline())
    L.append(A)
L2 = set(L)

for _ in range(M):
    A = str(sys.stdin.readline())
    if A in L2:
        cnt += 1

print(cnt)