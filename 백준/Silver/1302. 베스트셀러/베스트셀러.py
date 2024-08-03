import sys

D = {}

N = int(sys.stdin.readline())

for _ in range(N):
    S = str(sys.stdin.readline().rstrip())

    if S in D:
        D[S] += 1
    else:
        D[S] = 1

D1 = sorted(D.items(), key=lambda x : (-x[1], x[0]))

print(D1[0][0])
