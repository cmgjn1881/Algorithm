import sys

L = []
N = int(sys.stdin.readline())
for i in range(N):
    name, a, b, c = map(str, sys.stdin.readline().split())
    L.append([name, int(a), int(b), int(c)])

L2 = sorted(L, key=lambda x : (-x[1], x[2], -x[3], x[0]))

for i in range(len(L2)):
    print(L2[i][0])