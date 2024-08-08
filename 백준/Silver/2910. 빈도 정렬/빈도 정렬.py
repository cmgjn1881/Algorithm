import sys

N, C = map(int,  sys.stdin.readline().split())

L = list(map(int, sys.stdin.readline().split()))

D = {}
P = 1
for i in L:
    if i in D:
        D[i][0] += 1
    else:
        D[i] = [1, P]
        P += 1

result = sorted(D.items(), key=lambda x : (-x[1][0], x[1][1]))

for i in result:
    k = i[1][0]
    for _ in range(k):
        print(i[0], end=" ")