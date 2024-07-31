import sys
from collections import deque

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
C = list(map(int, sys.stdin.readline().split()))

Q = deque()

for i in range(N):
    if A[i] == 0:
        Q.append(B[i])

for i in range(M):
    Q.appendleft(C[i])
    print(Q.pop(), end=" ")