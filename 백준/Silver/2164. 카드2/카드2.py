import sys
from collections import deque

N = sys.stdin.readline()

Q = deque([])
for i in range(int(N)):
    Q.append(i + 1)

for i in range(int(N) - 1):
    Q.popleft()
    Q.append(Q.popleft())

print(Q[0])