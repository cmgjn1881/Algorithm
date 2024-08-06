import sys

N = int(sys.stdin.readline())
L = []
D = {}

for _ in range(N):
    a = int(sys.stdin.readline())
    L.append(a)
    if a in D:
        D[a] += 1
    else:
        D[a] = 1

L.sort()
mx = max(D.values())
mx_L = []

for i in D:
    if mx == D[i]:
        mx_L.append(i)

mx_L.sort()

mode = mx_L[0]
if len(mx_L) > 1:
    mode = mx_L[1]

avg = round(sum(L) / N)
Mid = L[N // 2]
Range = L[-1] - L[0]

print(avg)
print(Mid)
print(mode)
print(Range)