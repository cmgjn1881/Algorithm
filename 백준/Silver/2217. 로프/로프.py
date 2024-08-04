import sys

N = int(sys.stdin.readline())
L = []

for _ in range(N):
    a = int(sys.stdin.readline())
    L.append(a)

L.sort()
Max = 0
for i in range(N):
    s = len(L)
    x = L.pop(0)
    if Max <= s * x:
        Max = s * x

print(Max)