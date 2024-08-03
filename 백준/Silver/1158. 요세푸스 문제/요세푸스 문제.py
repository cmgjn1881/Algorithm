import sys
from collections import deque

Q = deque()
L = []

N, K = map(int, sys.stdin.readline().split())

for i in range(1, N + 1):
    Q.append(i)

while len(Q) > 0:
    for i in range(1, K):
        Q.append(Q.popleft())
    L.append(str(Q.popleft()))

print("<", ', '.join(L), ">",  sep="")