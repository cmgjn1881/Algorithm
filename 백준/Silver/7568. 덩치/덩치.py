import sys

N = int(sys.stdin.readline())

L = []

for i in range(N):
    a, b = map(int, sys.stdin.readline().split())
    L.append([a, b])

for i in L:
    cnt = 0
    for j in L:
        if j[0] > i[0] and j[1] > i[1]:
            cnt += 1
    print(cnt + 1, end=" ")