import sys

N = int(sys.stdin.readline())
D = {}

for _ in range(N):
    a = int(sys.stdin.readline())

    if a in D:
        D[a] += 1
    else:
        D[a] = 1


result = sorted(D.items(), key=lambda x : (-x[1], x[0]))

print(result[0][0])