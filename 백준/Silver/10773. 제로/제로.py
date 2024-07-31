import sys

K = int(sys.stdin.readline())
L = []

for _ in range(K):
    n = int(sys.stdin.readline())

    if n != 0:
        L.append(n)
    else:
        L.pop()

print(sum(L))