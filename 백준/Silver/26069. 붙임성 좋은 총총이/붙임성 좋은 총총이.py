import sys

N = int(sys.stdin.readline())
D = {}
D["ChongChong"] = 1

for i in range(N):
    a, b = map(str, sys.stdin.readline().rstrip().split())

    if D.get(a) == 1 or D.get(b) == 1:
        D[a] = 1
        D[b] = 1
    else:
        D[a] = 0
        D[b] = 0

cnt = 0
for x in D.values():
    if x == 1:
        cnt += 1

print(cnt)