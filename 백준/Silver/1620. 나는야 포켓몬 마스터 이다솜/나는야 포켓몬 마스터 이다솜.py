import sys

N, M = map(int, sys.stdin.readline().split())

D = {}
D2 = {}

for i in range(1, N + 1):
    name = sys.stdin.readline().rstrip()
    D[i] = name
    D2[name] = i

for i in range(M):
    X = sys.stdin.readline().rstrip()
    if X.isdigit():
        print(D[int(X)])
    else:
        print(D2[X])