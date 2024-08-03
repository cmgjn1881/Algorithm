import sys

D = {}

N, M = map(int, sys.stdin.readline().split())

for _ in range(N):
    a, b = map(str, sys.stdin.readline().rstrip().split())
    D[a] = b

for _ in range(M):
    x = str(sys.stdin.readline().rstrip())
    print(D.get(str(x)))